package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.*;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.controller.commands.levels.Room;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;

import edu.kit.informatik.controller.commands.requests.Reward;
import edu.kit.informatik.controller.commands.resources.QuitException;
import edu.kit.informatik.model.abilities.*;
import edu.kit.informatik.model.abilities.player_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.player_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.player_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.player_abilities.magical.Reflect;
import edu.kit.informatik.model.abilities.player_abilities.magical.Water;
import edu.kit.informatik.model.abilities.player_abilities.physical.*;
import edu.kit.informatik.model.enteties.*;
import edu.kit.informatik.model.enteties.monster.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class RunasStrive {
    private final Session session;
    private final Player player;
    private int level;
    private int room;
    private List<Card> playerCards;
    Queue<List<Monster>> monster;
    private Level currentLevel;
    private Room currentRoom;
    private AnswerFlag status = AnswerFlag.VALID;
    private List<Monster> deadMonsters = new ArrayList<>();

    public RunasStrive(Session session, Player player) {
        this.session = session;
        this.player = player;
        this.level = 1;
        this.room = 1;
        initMonster();
    }


    public void start() throws QuitException {
        for (int i = 0; i < 3 && status == AnswerFlag.VALID; i++) {
            loadLevel();
            room = 1;
        }
    }

    private void loadLevel() throws QuitException {
        initPlayerCards();
        shuffleCards();
        currentLevel = new Level(this.player, this.monster.poll(), level);
        loadRoom();
        this.level++;
    }

    private void loadRoom() throws QuitException {
        for (int i = 0; i < 4 && status == AnswerFlag.VALID; i++) {
            currentRoom = currentLevel.loadRoom();
            combat();
            if (room != 4) {
                requestReward();
            } else {
                if (level == 2) {
                    this.session.printRunaWon();
                    throw new QuitException();
                }
                upgradeStarterCards();
            }
            if (this.player.getCurrentHp() < this.player.getMaxHp() && this.player.getCards().size() > 1)
                requestHealing();
            room++;
        }
    }

    private void upgradeStarterCards() {
        List<Card> upgradedCards = CharacterClass.getCards(this.player.getCharacterClass(), this.player);
        for (Card card : upgradedCards) {
            card.upgradeCard();
        }
        this.player.addCards(upgradedCards);
        this.session.printCardReceptions(upgradedCards);
    }


    private void combat() throws QuitException {
        this.session.printIntro(room, currentLevel);
        while (currentRoom.monstersAlive() && this.player.getCurrentHp() > 0 && status == AnswerFlag.VALID) {
            this.session.printEncounter(currentRoom.getMonsters());
            requestCard();
            evaluateCard(this.player, this.player.getCurrentCard());
            for (Monster monster : currentRoom.getMonsters()) {
                if (monster.getCurrentHp() > 0) checkFocus(monster);
            }
            for (Monster monster : currentRoom.getMonsters()) {
                monster.setCurrentTarget(this.player);
                monster.getCard();
                checkCost(monster, monster.getCurrentCard());
                evaluateCard(monster, monster.getCurrentCard());
            }
            //todo: remove monster after loop
            for (Monster monster : deadMonsters) {
                currentRoom.removeMonster(monster);
            }
            deadMonsters.clear();
            checkFocus(this.player);
        }
    }

    private void checkCost(Monster monster, Card card) {
        if (card.getCardType().equals(CardType.OFFENSIVE)) {
            OffensiveCard attack = (OffensiveCard) card;
            if (monster.getFocusPoints() < attack.getAbilityLevel() && attack.getCardClass() == CardClass.MAGICAL) {
                monster.getCard();
                checkCost(monster, monster.getCurrentCard());
            }
        }
    }

    //Todo: Die for Runa's death
    private void evaluateCard(Entity entity, Card card) throws QuitException {
        if (entity.getCurrentHp() > 0) {
            if (card.getCardType().equals(CardType.OFFENSIVE)) {
                //check for target input
                if (entity.isPlayer() && this.currentRoom.getMonsters().size() > 1) requestTarget();
                else if (entity.isPlayer()) entity.setCurrentTarget(this.currentRoom.getMonsters().get(0));
                //evaluate offensive card
                evaluateOffensive(entity, (OffensiveCard) card);
            } else if (card.getCardType().equals(CardType.DEFENSIVE)) {
                this.session.printTurn(entity, card);
            } else {
                session.printTurn(entity, card);
                checkFocus(entity);
                entity.toggleFocus();
            }
        }
    }

    private void checkFocus(Entity entity) {
        if (entity.isFocused()) {
            session.printFocus(entity, entity.increaseFocusPoints(entity.getCurrentCard().getAbilityLevel()));
            entity.toggleFocus();
        }
    }


    private void evaluateOffensive(Entity attacker, OffensiveCard card) throws QuitException {
        CardClass cardClass = card.getCardClass();
        Entity target = attacker.getCurrentTarget();
        this.session.printTurn(attacker, card);
        //check break focus
        if (target.isFocused() && card.breaksFocus()) target.toggleFocus();
        //check monster is able to use its current cards
        int damage;
        boolean reflect = false;
        if (cardClass.equals(CardClass.MAGICAL)) {
            // card is magical
            if (attacker.isPlayer()) {
                damage = card.getDamage(attacker.getFocusPoints());
                MonsterType enemy = ((Monster) target).getMonsterType();
                //calculate damage
                damage += (card.isEffectiveOn(enemy) ? 2 * card.getAbilityLevel() : 0);
            } else {
                damage = card.getDamage(0);
            }
            attacker.decreaseFocusPoints(card.getAbilityLevel());
        } else {
            // Card is physical
            cardClass = CardClass.PHYSICAL;
            if (attacker.isPlayer())
                damage = card.getDamage(requestDice());
            else
                damage = card.getDamage(0);
            // Physical card
        }
        // calculate defense
        if (target.getCurrentCard() != null && target.getCurrentCard().getCardType() == CardType.DEFENSIVE &&
                attacker.getCurrentCard().getCardClass() == target.getCurrentCard().getCardClass()) {
            damage = calcDamageAfterDefense(attacker, damage);
            reflect = target.getCurrentCard().getName().equals("Reflect");
        }
        if (reflect) {
            if (damage > 0) {
                // attacker and target receive damage
                attacker.dealDamage(Math.abs(calcDamageAfterDefense(attacker, 0)));
                this.session.printDamage(target, damage, cardClass.getShortCut());
                checkDeath(target);
                this.session.printDamage(attacker, Math.abs(calcDamageAfterDefense(attacker, 0)), cardClass.getShortCut());
            } else {
                // only attacker receives damage
                attacker.dealDamage(card.getDamage(0));
                this.session.printDamage(attacker, card.getDamage(0), cardClass.getShortCut());
            }
        }
        target.dealDamage(damage);
        //jetzt alles ausgeben
        if (!reflect)
            this.session.printDamage(target, damage, cardClass.getShortCut());
        checkDeath(target);
        checkDeath(attacker);

    }

    private void checkDeath(Entity target) throws QuitException {
        if (target.getCurrentHp() <= 0) {
            session.printDeath(target);
            if (target.isPlayer())
                throw new QuitException();
            else
                deadMonsters.add((Monster) target);
        }
    }

    private int calcDamageAfterDefense(Entity attacker, int damage) {
        DefensiveCard defense = (DefensiveCard) attacker.getCurrentTarget().getCurrentCard();
        return damage - defense.getDefense();
    }

    private void requestReward() throws QuitException {
        RewardReqeust rewardReqeust = new RewardReqeust(this.player);
        if (this.player.getDice() < this.player.getMaxDice())
            this.session.requestInput(rewardReqeust);
        else
            rewardReqeust.setValue(Reward.ABILITY);
        if (!rewardReqeust.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            if (rewardReqeust.getValue().equals(Reward.DICE)) {
                this.player.increaseDice(this.player.getDice() + 2);
                this.session.printUpgradeDice(this.player);
            } else {
                requestCardReward();
            }
        } else {
            status = AnswerFlag.QUIT;
        }
    }

    private void requestHealing() throws QuitException {
        HealRequest heal = new HealRequest(this.player, this.player.getCards());
        this.session.requestInput(heal);
        if (!heal.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            if (heal.getValue().isEmpty())
                return;
            for (int i = 0; i < heal.getValue().size(); i++) {
                this.player.getCards().remove(heal.getValue().get(i) - i);
            }
            this.session.printHealing(this.player.heal(10 * heal.getValue().size()));
        } else {
            status = AnswerFlag.QUIT;
        }
    }

    private void requestCardReward() throws QuitException {
        List<Card> options = this.playerCards.subList(0, room > 1 ? Math.min(4, this.playerCards.size()) : 2);
        CardRewardRequest cardRewardRequest = new CardRewardRequest(options);
        this.session.requestInput(cardRewardRequest);
        if (!cardRewardRequest.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            this.player.addCards(cardRewardRequest.getValue());
            this.session.printCardReceptions(cardRewardRequest.getValue());
            this.playerCards.removeAll(options);
        } else {
            status = AnswerFlag.QUIT;
        }
    }

    private int requestDice() throws QuitException {
        DiceRollRequest rollRequest = new DiceRollRequest(this.player.getDice());
        this.session.requestInput(rollRequest);
        if (!rollRequest.getAnswerFlag().equals(AnswerFlag.QUIT)) return rollRequest.getValue();
        else status = AnswerFlag.QUIT;

        return 0;
    }

    private void requestTarget() throws QuitException {
        TargetRequest targetSelection = new TargetRequest(this.currentRoom.getMonsters());
        this.session.requestInput(targetSelection);
        if (!targetSelection.getAnswerFlag().equals(AnswerFlag.QUIT))
            this.player.setCurrentTarget(targetSelection.getValue());
        else
            status = AnswerFlag.QUIT;
    }

    private void requestCard() throws QuitException {
        SelectCardRequest cardSelection = new SelectCardRequest(this.player.getCards());
        this.session.requestInput(cardSelection);
        if (!cardSelection.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            this.player.setCurrentCard(cardSelection.getValue());
        } else {
            status = AnswerFlag.QUIT;
        }
    }

    private void shuffle(int seedPlayer, int seedMonster) {
        Collections.shuffle(this.playerCards, new Random(seedPlayer));
        Collections.shuffle(this.monster.element(), new Random(seedMonster));
    }

    private void initMonster() {
        this.monster = new LinkedList<>() {{
            add(new ArrayList<>(List.of(new Frog(), new Ghost(), new Gorgon(), new Skeleton(), new Spider(), new Goblin(), new Rat(), new Mushroomlin())) {
            });
            add(new ArrayList<>(List.of(new Snake(), new DarkElf(), new ShadowBlade(), new Hornet(), new Tarantula(), new Bear(), new Mushroomlon(), new WildBoar())));
        }};
    }

    private void initPlayerCards() {
        this.playerCards = new ArrayList<>(List.of(new Slash(this.level), new Swing(this.level), new Thrust(this.level),
                new Pierce(this.level), new Parry(this.level), new Focus(this.level), new Reflect(this.level),
                new Water(this.level), new Ice(this.level), new Fire(this.level), new Lightning(this.level)));
        this.playerCards.removeAll(CharacterClass.getCards(this.player.getCharacterClass(), this.player));

    }


    private void shuffleCards() throws QuitException {
        ShuffleCardRequest shuffle = new ShuffleCardRequest();
        this.session.requestInput(shuffle);
        if (!shuffle.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            shuffle(shuffle.getValue().poll(), shuffle.getValue().poll());
        } else {
            status = AnswerFlag.QUIT;
        }
    }
}