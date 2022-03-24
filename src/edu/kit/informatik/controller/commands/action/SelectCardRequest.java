package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class SelectCardRequest extends InputRequest<Card> {
    private static final StringBuilder QUESTION = new StringBuilder("Select card to play \n");
    private static final String ANSWER = "Enter number [1--%d]";
    private static final String REGEX = "[1-%d]";
    private final List<Card> cards;

    public SelectCardRequest(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
        } else {
            if (input.matches(String.format(REGEX, this.cards.size()))) {
                setAnswerFlag(AnswerFlag.VALID);
                System.out.println(this.cards.size());
                setValue(this.cards.get(Integer.parseInt(input) - 1));
            } else {
                setAnswerFlag(AnswerFlag.UNUSABLE);
            }
        }
    }

    @Override
    public String getQuestion() {

        for (int i = 0; i < this.cards.size(); i++) {
            QUESTION.append(String.format("%d) %s \n", i + 1, this.cards.get(i).toString()));
        }
        return QUESTION.substring(0, QUESTION.length() - 1);
    }

    @Override
    public String getAnswer() {
        return String.format(ANSWER, this.cards.size());
    }
}
