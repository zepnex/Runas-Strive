package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.CharacterClassRequest;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.controller.commands.resources.QuitException;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Entity;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents a session of the game.
 *
 * @author unyrg
 * @version 1.0
 */
public class Session {
    private static final String WELCOME = "Welcome to Runa's Strive";
    private final Scanner scanner;
    private Player player;

    /**
     * This constructor creates a new session.
     */
    public Session() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * This method starts the game.
     *
     * @throws QuitException if the user quits the game
     */
    public void start() throws QuitException {
        System.out.println(WELCOME);
        if (this.player == null) {
            CharacterClassRequest request = new CharacterClassRequest();
            requestInput(request);
            if (!request.getAnswerFlag().equals(AnswerFlag.QUIT)) {
                this.player = new Player(request.getValue());
                new RunasStrive(this, this.player).start();
            }
        }
    }

    /**
     * This methode requests input from the user.
     *
     * @param request the request to be processed
     * @throws QuitException if the user quits the game
     */
    public void requestInput(InputRequest<?> request) throws QuitException {
        System.out.print(request.getQuestion());
        while (request.getAnswerFlag().equals(AnswerFlag.INVALID)) {
            System.out.println(request.getAnswer());
            request.process(this.scanner.nextLine());
            if (request.getAnswerFlag().equals(AnswerFlag.QUIT)) {
                throw new QuitException();
            }
        }
    }

    /**
     * This method prints the damage the entity received.
     *
     * @param entity the entity that received the damage
     * @param damage the damage received
     * @param type   the type of damage
     */
    public void printDamage(Entity entity, int damage, String type) {
        if (damage > 0)
            System.out.printf("%s takes %d %s damage\n", entity.getName(), damage, type);
    }

    /**
     * This methode print the action of an entity.
     *
     * @param entity the entity that performed the action
     * @param card   the card that was used
     */
    public void printTurn(Entity entity, Card card) {
        System.out.printf("%s uses %s\n", entity.getName(), card.toString());
    }

    /**
     * This method prints the focus of the entity.
     *
     * @param entity      the entity that received uses focus
     * @param focusPoints the focus points the entity receives
     */
    public void printFocus(Entity entity, int focusPoints) {
        if (focusPoints > 0)
            System.out.printf("%s gains %d focus\n", entity.getName(), focusPoints);
    }

    /**
     * This method prints the upgrade of the players dice.
     *
     * @param player the player that received the upgrade
     */
    public void printUpgradeDice(Player player) {
        System.out.printf("Runa upgrades her die to a d%d\n", player.getDice());
    }

    /**
     * This methode prints the card the player received.
     *
     * @param cards the cards the player received
     */
    public void printCardReceptions(List<Card> cards) {
        for (Card card : cards) {
            System.out.printf("Runa gets %s\n", card.toString());
        }
    }

    /**
     * This method prints how much the player healed.
     *
     * @param healing the amount of healing
     */
    public void printHealing(int healing) {
        System.out.printf("Runa gains %d health\n", healing);
    }

    /**
     * This method prints the death of an entity.
     *
     * @param entity the entity that died
     */
    public void printDeath(Entity entity) {
        System.out.printf("%s dies\n", entity.getName());
    }

    /**
     * This method prints the victory of the player.
     */
    public void printRunaWon() {
        System.out.println("Runa won!");
    }

    /**
     * This method prints the entrance of a room.
     *
     * @param stage the stage the player entered
     * @param level the current level
     */
    public void printIntro(int stage, Level level) {
        System.out.printf("Runa enters Stage %d of Level %d\n", stage, level.getLevel());
    }

    /**
     * This method prints the current status of the fight.
     *
     * @param monsters the monsters in the fight
     */
    public void printEncounter(List<Monster> monsters) {
        System.out.println("----------------------------------------");
        System.out.printf("Runa (%d/%d HP, %d/%d FP)\n", this.player.getCurrentHp(), this.player.getMaxHp(),
                this.player.getFocusPoints(), this.player.getDice());
        System.out.println("vs.");
        for (Monster monster : monsters) {
            if (monster.getCurrentHp() > 0) {
                System.out.printf("%s (%d HP, %d FP): attempts %s next\n", monster.getName(), monster.getCurrentHp(),
                        monster.getFocusPoints(), monster.getAbilities().element().toString());
            }
        }
        System.out.println("----------------------------------------");
    }
}
