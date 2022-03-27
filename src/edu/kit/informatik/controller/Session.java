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

public class Session {
    private static final String WELCOME = "Welcome to Runa's Strive";
    private final Scanner scanner;
    private Player player;
    private RunasStrive game;

    public Session() {
        this.scanner = new Scanner(System.in);
    }

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


    public void requestInput(InputRequest<?> request) throws QuitException {
        System.out.print(request.getQuestion());
        while (request.getAnswerFlag().equals(AnswerFlag.UNUSABLE)) {
            System.out.println(request.getAnswer());
            request.process(this.scanner.nextLine());
            if (request.getAnswerFlag().equals(AnswerFlag.QUIT)) {
               throw new QuitException();
            }
        }
    }

    public void printDamage(Entity entity, int damage, String type) {
        if (damage > 0)
            System.out.printf("%s takes %d %s damage\n", entity.getName(), damage, type);
    }

    public void printTurn(Entity entity, Card card) {
        System.out.printf("%s uses %s\n", entity.getName(), card.toString());
    }

    public void printFocus(Entity entity, int focusPoints) {
        if (focusPoints > 0)
            System.out.printf("%s gains %d focus\n", entity.getName(), focusPoints);
    }

    public void printUpgradeDice(Player player) {
        System.out.printf("Runa upgrades her die to a d%d\n", player.getDice());
    }

    public void printCardReceptions(List<Card> cards) {
        for (Card card : cards) {
            System.out.printf("Runa gets %s\n", card.toString());
        }
    }

    public void printHealing(int healing) {
        System.out.printf("Runa gains %d health\n", healing);
    }

    public void printDeath(Entity entity) {
        System.out.printf("%s dies\n", entity.getName());
    }

    public void printRunaWon() {
        System.out.println("Runa won!");
    }

    public void printIntro(int stage, Level level) {
        System.out.printf("Runa enters Stage %d of Level %d\n", stage, level.getLevel());
    }

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
