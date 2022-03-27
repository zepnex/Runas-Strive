package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.*;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.controller.commands.levels.Room;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;

import edu.kit.informatik.controller.commands.requests.Reward;
import edu.kit.informatik.model.abilities.*;
import edu.kit.informatik.model.abilities.player_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.player_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.player_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.player_abilities.magical.Reflect;
import edu.kit.informatik.model.abilities.player_abilities.magical.Water;
import edu.kit.informatik.model.abilities.player_abilities.physical.*;
import edu.kit.informatik.model.enteties.Entity;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;
import edu.kit.informatik.model.enteties.Player;
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

    public RunasStrive(Session session, Player player) {
        this.session = session;
        this.player = player;
        this.level = 1;
        this.room = 1;
        initCards();
    }


    public void start() {
        loadLevel();
    }

    /**
     * Todo: combat logik hier auslegen und room und level nur als modellierung nutzen
     */


    private void loadLevel() {
        shuffleCards();
        currentLevel = new Level(this.player, this.monster.poll(), level);
        this.level++;
        loadRoom();
    }

    private void loadRoom() {
        for (int i = 0; i < 4; i++) {
            currentRoom = currentLevel.loadRoom();
            combat();
            if (room != 4) {
                requestReward();
            } else {
                //todo: update level
                upgradeStarterCards();
            }
            if (this.player.getCurrentHp() < this.player.getMaxHp())
                requestHealing();
            room++;
        }
    }

    private void upgradeStarterCards() {
        for (int i = 0; i < 2; i++) {
            this.player.getCards().get(i).upgradeCard();
        }
    }


    private void combat() {
        this.currentRoom.printIntro();
        while (currentRoom.monstersAlive() && this.player.getCurrentHp() > 0) {
            currentRoom.printEncounter();
            requestCard();
            evaluateCard(this.player, this.player.getCurrentCard());
            for (Monster monster : currentRoom.getMonsters()) {

                monster.setCurrentTarget(this.player);
                monster.getCard();
                if (monster.getCurrentHp() > 0) checkFocus(monster);
                checkCost(monster, monster.getCurrentCard());
                evaluateCard(monster, monster.getCurrentCard());
            }
            checkFocus(this.player);
        }
    }

    private void checkCost(Monster monster, Card card) {
        if (card.getCardType().equals(CardType.OFFENSIVE)) {
            OffensiveCard attack = (OffensiveCard) card;
            if (monster.getFocusPoints() < attack.getCost()) {
                monster.getCard();
                checkCost(monster, monster.getCurrentCard());
            }
        }
    }

    //Todo: Die for Runa's death
    private void evaluateCard(Entity entity, Card card) {
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
        } else {
            // session.printDeath(entity);
        }
    }

    private void checkFocus(Entity entity) {
        if (entity.isFocused()) {
            entity.increaseFocusPoints();
            session.printFocus(entity);
            entity.toggleFocus();
        }
    }

    private void evaluateOffensive(Entity entity, OffensiveCard card) {
        Entity target = entity.getCurrentTarget();
        int damage;
        boolean isReflected = false;
        this.session.printTurn(entity, card);
        //check break focus
        if (target.isFocused() && card.breaksFocus()) target.toggleFocus();
        //check monster is able to use its current cards
        if (card.getCardClass().equals(CardClass.MAGICAL)) {
            // if magical card
            damage = card.getDamage(card.getAbilityLevel(), entity.getFocusPoints());
            if (entity.isPlayer()) {
                MonsterType enemy = ((Monster) target).getMonsterType();
                //calculate damage
                damage += (card.isEffectiveOn(enemy) ? 2 * card.getAbilityLevel() : 0);
            }
            int newDamage = 0;
            if (target.getCurrentCard() != null && target.getCurrentCard().getCardType().equals(CardType.DEFENSIVE))
                //check if target has a defensive card
                newDamage = checkMagicalDefense(entity, damage);
            if (!entity.isPlayer()) {
                //deal damage to monster because of reflection card
                //entity.dealDamage(Math.abs(damage));
                //positive zahl monster macht noch mehr dmg aber runa reflektiert alles
                //negative zahl runa reflektiert nur ein gewissen teil
                int cardDefensive = 0;
                if (newDamage > 0 && target.getCurrentCard().getCardType().equals(CardType.DEFENSIVE)) {
                    DefensiveCard reflect = (DefensiveCard) target.getCurrentCard();
                    cardDefensive = reflect.getDefense(reflect.getAbilityLevel());
                    //card is relfect
                    entity.dealDamage(reflect.getDefense(reflect.getAbilityLevel()));
                    target.dealDamage(newDamage);
                    this.session.printDamage(target, newDamage, card.getCardClass().getShortCut());
                    isReflected = true;
                    this.session.printDamage(entity, cardDefensive, card.getCardClass().getShortCut());
                } else {
                    target.dealDamage(damage + cardDefensive);
                }
            } else if (damage > 0) {
                target.dealDamage(damage);
            }
            //decrease focus points
            entity.decreaseFocusPoints(card.getCost());
        } else {
            //if physical card
            if (entity.isPlayer()) damage = card.getDamage(card.getAbilityLevel(), requestDice());
                //calculate damage for player
            else damage = card.getDamage(card.getAbilityLevel(), 0);
            //check if target has a defensive card
            if (target.getCurrentCard() != null && target.getCurrentCard().getCardType().equals(CardType.DEFENSIVE))
                //calculate damage with defensive card
                damage = checkPhysicalDefense(entity, damage);
            if (damage > 0) target.dealDamage(damage);
        }
        if (damage > 0 && !isReflected)
            //print damage
            this.session.printDamage(target, damage, card.getCardClass().getShortCut());


        checkDeath(target);
    }

    private void checkDeath(Entity target) {
        if (target.getCurrentHp() <= 0) {
            session.printDeath(target);
        }
    }

    private int checkPhysicalDefense(Entity attacker, int damage) {
        DefensiveCard defenderCard = (DefensiveCard) attacker.getCurrentTarget().getCurrentCard();
        if (defenderCard.getCardClass().equals(CardClass.PHYSICAL)) {
            damage -= defenderCard.getDefense(defenderCard.getAbilityLevel());
        }
        return Math.max(damage, 0);
    }

    private int checkMagicalDefense(Entity attacker, int damage) {
        DefensiveCard defenderCard = (DefensiveCard) attacker.getCurrentTarget().getCurrentCard();
        if (defenderCard.getCardClass().equals(CardClass.MAGICAL)) {
            return damage - defenderCard.getDefense(defenderCard.getAbilityLevel());
        }
        return damage;
    }

    private void requestReward() {
        RewardReqeust rewardReqeust = new RewardReqeust();
        this.session.requestInput(rewardReqeust);
        if (!rewardReqeust.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            if (rewardReqeust.getValue().equals(Reward.DICE)) {
                this.player.increaseDice(this.player.getDice() + 2);
                this.session.printUpgradeDice(this.player);
            } else {
                requestCardReward();
            }
        }

    }

    private void requestHealing() {
        HealRequest heal = new HealRequest(this.player, this.player.getCards());
        this.session.requestInput(heal);
        if (!heal.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            if (heal.getValue().isEmpty())
                return;
            this.player.getCards().removeAll(heal.getValue());
            this.session.printHealing(this.player.heal(10 * heal.getValue().size()));
        }
    }

    private void requestCardReward() {
        List<Card> options = this.playerCards.subList(0, room > 1 ? 4 : 2);
        CardRewardRequest cardRewardRequest = new CardRewardRequest(options);
        this.session.requestInput(cardRewardRequest);
        if (!cardRewardRequest.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            this.player.addCards(cardRewardRequest.getValue());
            this.session.printCardReceptions(cardRewardRequest.getValue());
            this.playerCards.removeAll(options);
        }
    }

    private int requestDice() {
        DiceRollRequest rollRequest = new DiceRollRequest(this.player.getDice());
        this.session.requestInput(rollRequest);
        if (!rollRequest.getAnswerFlag().equals(AnswerFlag.QUIT)) return rollRequest.getValue();
        return 0;
    }

    private void requestTarget() {
        TargetRequest targetSelection = new TargetRequest(this.currentRoom.getMonsters());
        this.session.requestInput(targetSelection);
        if (!targetSelection.getAnswerFlag().equals(AnswerFlag.QUIT))
            this.player.setCurrentTarget(targetSelection.getValue());
    }

    private void requestCard() {
        SelectCardRequest cardSelection = new SelectCardRequest(this.player.getCards());
        this.session.requestInput(cardSelection);
        if (!cardSelection.getAnswerFlag().equals(AnswerFlag.QUIT))
            this.player.setCurrentCard(cardSelection.getValue());
    }


    //Todo: initCards und shuffle wo anders hin
    private void shuffle(int seedPlayer, int seedMonster) {
        Collections.shuffle(this.playerCards, new Random(seedPlayer));
        Collections.shuffle(this.monster.element(), new Random(seedMonster));
    }

    private void initCards() {
        this.playerCards = new ArrayList<>(List.of(new Slash(this.level), new Swing(this.level), new Thrust(this.level),
                new Pierce(this.level), new Parry(this.level), new Focus(this.level), new Reflect(this.level),
                new Water(this.level), new Ice(this.level), new Fire(this.level), new Lightning(this.level)));
        this.playerCards.removeAll(this.player.getCards());

        this.monster = new LinkedList<>() {{
            add(new ArrayList<>(List.of(new Frog(), new Ghost(), new Gorgon(), new Skeleton(), new Spider(), new Goblin(), new Rat(), new Mushroomlin())) {
            });
            add(new ArrayList<>(List.of(new Snake(), new DarkElf(), new ShadowBlade(), new Hornet(), new Tarantula(), new Bear(), new Mushroomlon(), new WildBoar())));
        }};
    }


    private void shuffleCards() {
        ShuffleCardRequest shuffle = new ShuffleCardRequest();
        this.session.requestInput(shuffle);
        if (!shuffle.getAnswerFlag().equals(AnswerFlag.QUIT)) {
            shuffle(shuffle.getValue().poll(), shuffle.getValue().poll());
        }
    }
}

/**
 * Todo: Heal, Reward, Die/Win,
 */