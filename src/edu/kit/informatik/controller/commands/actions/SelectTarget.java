package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Monster;

import java.util.List;

public class SelectTarget extends Choosable {
    private static final String QUESTION = "Select Runa's Target";
    List<Monster> answers;

    public SelectTarget(List<Monster> answers) {
        this.answers = answers;
    }

    @Override
    public void printQuestion() {
        System.out.println(QUESTION);
    }

    @Override
    public void printAnswer() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.answers.size(); i++) {
            Monster monster = this.answers.get(i);
            builder.append(String.format("%d) %s\n", i + 1, monster.getName()));
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }

    @Override
    public void printChoices() {
        System.out.printf("Enter number [1--%s]", this.answers.size());
    }

    @Override
    public void execute(String input) {
        System.out.println("STOP ASIAN HATE");
    }

    @Override
    public boolean apply(String input) {
        return false;
    }
}
