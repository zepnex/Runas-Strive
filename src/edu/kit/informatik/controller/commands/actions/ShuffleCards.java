package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.RunasStrive;
import edu.kit.informatik.controller.commands.Choosable;

import java.util.LinkedList;
import java.util.Queue;

public class ShuffleCards extends Choosable {
    private static final String QUESTION = "To shuffle ability cards and monster, enter two seeds";
    private static final String ANSWER = "Enter seed [1--2147483647]";
    RunasStrive game;

    public ShuffleCards(RunasStrive game) {
        this.game = game;
    }

    @Override
    public void printQuestion() {
        System.out.println(QUESTION);
    }

    @Override
    public void printAnswer() {
        System.out.println(ANSWER);
    }

    @Override
    public void printChoices() {

    }

    @Override
    public void execute(String input) {
        Queue<Integer> seeds = new LinkedList<>();
        for (String seed : input.split(",")) {
            seeds.add(Integer.parseInt(seed));
        }
        game.initCards(seeds);
    }

    @Override
    public boolean apply(String input) {
        String[] seeds = input.split(",");
        if (seeds.length != 2) return false;
        boolean correct;
        for (String seed : seeds) {
            if (seed.length() > 10 || seed.length() < 1) return false;
            long number = Long.parseLong(seed);
            correct = number <= Integer.MAX_VALUE && number >= 1;
            if (!correct) return false;
        }
        execute(input);
        return true;
    }
}
