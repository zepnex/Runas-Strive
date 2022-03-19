package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.abilities.Card;

import java.util.List;
import java.util.Optional;

public class ChooseCard extends Choosable {
    private static final String QUESTION = "Select card to play";
    private final List<Card> answers;

    public ChooseCard(List<Card> cards) {

        this.answers = cards;
    }

    @Override
    public void printQuestion() {
        System.out.println(QUESTION);
    }

    @Override
    public void printAnswer() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.answers.size(); i++) {
            Card card = this.answers.get(i);
            builder.append(String.format("%d) %s(%d) \n", i + 1, card.getName(), card.getAbilityLevel()));
        }
        System.out.println(builder);
    }

    @Override
    public void printChoices() {
        System.out.printf("Choose number [1--%d]%n", this.answers.size());
    }

    @Override
    public void execute(String input) {

    }

    @Override
    public boolean apply(String input) {
     return false;
    }

}
