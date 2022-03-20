package edu.kit.informatik.controller.commands.game;

public abstract class Level {

    boolean checkQuit(String input) {
        return input.equals("quit");
    }



}
