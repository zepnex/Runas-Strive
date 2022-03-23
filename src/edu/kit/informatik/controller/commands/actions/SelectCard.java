package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class SelectCard extends Choosable {
    private static final String QUESTION = "Select card to play";
    private final List<Card> answers;
    private final Player player;

    public SelectCard(Player player) {
        this.player = player;
        this.answers = this.player.getCards();
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
        System.out.println(builder.substring(0, builder.length() - 2));
    }

    @Override
    public void printChoices() {
        System.out.printf("Enter number [1--%d]%n", this.answers.size());
    }

    @Override
    public void execute(String input) {
        // TODO: do something with this card
        this.player.setCurrentAttackCard(this.answers.get(Integer.parseInt(input) - 1));
        //System.out.printf("%s (%d)",this.answers.get(Integer.parseInt(input) - 1).getName(), this.player.getAbilityLevel());

    }

    @Override
    public boolean apply(String input) {
        if (input.matches(String.format("[1-%d]", this.answers.size()))) {
            execute(input);
            return true;
        }
        return false;
    }

}
