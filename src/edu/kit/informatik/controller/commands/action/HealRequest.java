package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.CharacterClass;

import java.util.List;

public class HealRequest extends InputRequest<Integer> {
    private static final String QUESTION = "Runa (%d/%d) can discard ability cards for healing (or none)\n";
    private static final String ANSWER_SINGLE = "Enter number [1--2]:";
    private static final String ANSWER_MULTIPLE = "Enter numbers [1--%d] seperated by comma:";
    private static final String REGEX = "(\\d+,)*\\d";
    private final List<Card> playerCards;

    public HealRequest(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
            return;
        }
        if (input.matches(REGEX)) {
            if (playerCards.size() == 2) {
                singleAnswer(input);
            } else {
                multipleAnswer(input);
            }
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
    }

    private void singleAnswer(String input) {

    }

    private void multipleAnswer(String input) {

    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(QUESTION);
        for (int i = 0; i < playerCards.size(); i++) {
            builder.append(String.format("%d) %s\n", i + 1, playerCards.get(i).toString()));
        }

        return builder.toString();
    }

    @Override
    public String getAnswer() {
        if (playerCards.size() > 2) {
            return ANSWER_MULTIPLE;
        }
        return ANSWER_SINGLE;
    }
}