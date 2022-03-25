package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.action.CharacterClassRequest;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Entity;
import edu.kit.informatik.model.enteties.Player;

import java.util.Scanner;

public class Session {
    private final Scanner scanner;
    private Player player;

    public Session() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {

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
        System.out.printf("%s took %d %s damage\n", entity.getName(), damage, type);
    }

    public void printTurn(Entity entity, Card card) {
        System.out.printf("%s uses %s\n", entity.getName(), card.toString());
    }

    public void printFocus(Entity entity) {
        System.out.printf("%s gains 1 focus\n", entity.getName());
    }

    public void printDeath(Entity entity) {
        System.out.printf("%s dies\n", entity.getName());
    }
}
