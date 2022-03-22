package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.enteties.PlayerClass;

import java.util.List;

public class CombatRound extends Choosable {
    private static final String QUESTION = "Select Runa's character class";
    List<PlayerClass> answers;
    CombatRound() {

    }

    @Override
    public void printQuestion() {

    }

    @Override
    public void printAnswer() {

    }

    @Override
    public void printChoices() {

    }

    @Override
    public void execute(String input) {

    }

    @Override
    public boolean apply(String input) {
        return false;
    }
}
