package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.CharacterClassRequest;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Entity;
import edu.kit.informatik.model.enteties.Player;

import java.util.Scanner;

public class Session {
    private static final String WELCOME = "Welcome to Runa's Strive";
    private final Scanner scanner;
    private Player player;

    public Session() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
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


    public void requestInput(InputRequest<?> request) {
        System.out.print(request.getQuestion());
        while (request.getAnswerFlag().equals(AnswerFlag.UNUSABLE)) {
            System.out.println(request.getAnswer());
            request.process(this.scanner.nextLine());
            if (request.getAnswerFlag().equals(AnswerFlag.QUIT)) {
                return;
            }
        }
    }

    public void printDamage(Entity entity, int damage, String type) {
        System.out.printf("%s takes %d %s damage\n", entity.getName(), damage, type);
    }

    public void printTurn(Entity entity, Card card) {
        System.out.printf("%s uses %s\n", entity.getName(), card.toString());
    }

    public void printFocus(Entity entity) {
        if (entity.getFocusPoints() < entity.getMaxFocusPoint())
            System.out.printf("%s gains 1 focus\n", entity.getName());
    }

    public void printUpgradeDice(Player player) {
        System.err.printf("Runa upgrades her die to a d%d\n", player.getDice());

    }

    public void printAddCard() {

    }

    public void printDeath(Entity entity) {
        System.out.printf("%s dies\n", entity.getName());
    }

}
