package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.RunasStrive;
import edu.kit.informatik.controller.commands.Choosable;


public class ShuffleCards extends Choosable {
    private static final String QUESTION = "To shuffle ability cards and monster, enter two seeds";
    private static final String ANSWER = "Enter seed [1--2147483647]";
    private static final String MAX_INT_STR = String.valueOf(Integer.MAX_VALUE);
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
        String[] seeds = input.split(",");
        game.shuffle(Integer.parseInt(seeds[0]), Integer.parseInt(seeds[1]));
    }

    @Override
    public boolean apply(String input) {
        String[] seeds = input.split(",");
        if (seeds.length != 2) return false;
        boolean correct;
        for (String seed : seeds) {
            //check if numeric
            if (!seed.matches("^\\d+$")) return false;
            correct = seed.compareTo(MAX_INT_STR) <= 0 && seed.compareTo("0") > 0;
            if (!correct) return false;
        }

        execute(input);
        return true;
    }
}
