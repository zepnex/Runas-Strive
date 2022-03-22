package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.actions.PlayerCreation;
import edu.kit.informatik.model.enteties.Player;

import java.util.Scanner;

public class Session {
    private final Scanner scanner;
    private boolean running;
    private RunasStrive game;
    private Player player;

    public Session() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        this.running = true;
        while (this.running) {
            if (this.player == null) {
                createPlayer();
            } else if (game == null) {
                game = new RunasStrive(this, this.player);
                game.start();
            }
        }
        this.scanner.close();
    }


    public void stop() {
        this.running = false;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void createPlayer() {
        PlayerCreation create = new PlayerCreation(this);
        create.printQuestion();
        create.printAnswer();
        boolean satisfied = false;
        while (!satisfied) {
            create.printChoices();
            String input = this.scanner.nextLine();
            if (input.equals("quit")) {
                this.stop();
                break;
            }
            satisfied = create.apply(input);
        }
    }
}
