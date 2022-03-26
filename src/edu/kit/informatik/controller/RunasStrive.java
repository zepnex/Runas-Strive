package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.*;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.controller.commands.levels.Room;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;

import edu.kit.informatik.model.abilities.*;
import edu.kit.informatik.model.abilities.player_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.player_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.player_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.player_abilities.magical.Reflect;
import edu.kit.informatik.model.abilities.player_abilities.magical.Water;
import edu.kit.informatik.model.abilities.player_abilities.physical.Parry;
import edu.kit.informatik.model.abilities.player_abilities.physical.Slash;
import edu.kit.informatik.model.abilities.player_abilities.physical.Swing;
import edu.kit.informatik.model.abilities.player_abilities.physical.Thrust;
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

    void loadRoom() {
        for (int i = 0; i < 4; i++) {
            currentRoom = currentLevel.loadRoom();
            combat();
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
                evaluateCard(monster, monster.getCurrentCard());
            }
            checkFocus(this.player);
        }
    }

    private boolean checkCost(Monster entity, OffensiveCard card) {
        return entity.getFocusPoints() >= card.getCost();
    }

    //Todo: load next level
    private void evaluateCard(Entity entity, Card card) {
        if (entity.getCurrentHp() > 0) {
            if (card.getCardType().equals(CardType.OFFENSIVE)) {
                if (!entity.isPlayer()) checkFocus(entity);
                if (((OffensiveCard) card).getCost() <= entity.getFocusPoints()) {
                    if (entity.isPlayer() && this.currentRoom.getMonsters().size() > 1) {
                        requestTarget();
                    } else {
                        this.player.setCurrentTarget(currentRoom.getMonsters().get(0));
                    }
                    evaluateOffensive(entity, (OffensiveCard) card);
                    if (entity.isPlayer())
                        checkFocus(entity);
                }
            } else if (card.getCardType().equals(CardType.DEFENSIVE)) {

                session.printTurn(entity, card);
                if(!entity.isPlayer()) checkFocus(entity);

            } else {
                session.printTurn(entity, card);
                checkFocus(entity);
                entity.toggleFocus();
            }
        } else {
            this.session.printDeath(entity);
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

        this.session.printTurn(entity, card);
        if (card.getCardClass().equals(CardClass.MAGICAL)) entity.decreaseFocusPoints(card.getCost());
        if (entity.isPlayer()) {
            MonsterType enemy = ((Monster) target).getMonsterType();
            damage = card.getDamage(card.getAbilityLevel(), requestDice()) + (card.isEffectiveOn(enemy) ? 2 * card.getAbilityLevel() : 0);
        } else {
            while (checkCost((Monster) entity, card)) {
                ((Monster) entity).getCard();
            }
            damage = card.getDamage(card.getAbilityLevel(), 0);
        }
        if (target.getCurrentCard() != null && target.getCurrentCard().getCardType().equals(CardType.DEFENSIVE)) {
            DefensiveCard defense = (DefensiveCard) target.getCurrentCard();
            damage -= defense.getDefense(defense.getAbilityLevel());
        }
        if (damage >= 0) {
            target.dealDamage(damage);
        } else if (!entity.isPlayer() && target.getCurrentCard().getCardType().equals(CardType.DEFENSIVE)) {
            entity.dealDamage(Math.abs(damage));
        }


        this.session.printDamage(target, Math.max(damage, 0), card.getCardClass().getShortCut());

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
        this.playerCards = new ArrayList<>(List.of(new Fire(this.level), new Ice(this.level), new Lightning(this.level), new Reflect(this.level), new Water(this.level), new Parry(this.level), new Slash(this.level), new Swing(this.level), new Thrust(this.level), new Focus(this.level)));
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
 * Todo: Break focus
 */