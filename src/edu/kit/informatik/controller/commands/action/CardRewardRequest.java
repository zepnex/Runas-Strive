package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;

import java.util.ArrayList;
import java.util.List;

public class CardRewardRequest extends InputRequest<List<Card>> {
    private static final String QUESTION = "Pick %d card(s) as loot\n";
    private static final String MULTIPLE_ANSWER = "Enter numbers [1--%d] separated by comma:";
    private static final String SINGLE_ANSWER = "Enter number [1--%d]";
    private static final String REGEX = "(\\d+,)*\\d";
    private static final String REGEX_RANGE = "[1-%d]";
    private final List<Card> choices;

    public CardRewardRequest(List<Card> choices) {
        this.choices = choices;
    }

    @Override
    public void process(String input) {
        List<Card> chosenCards = new ArrayList<>();

        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
            return;
        }
        if (input.matches(REGEX)) {
            String[] numbers = input.split(",");
            for (String number : numbers) {
                if (number.matches(String.format(REGEX_RANGE, choices.size()))) {
                    chosenCards.add(choices.get(Integer.parseInt(number) - 1));
                }
            }
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
        if (chosenCards.size() == choices.size() / 2) {
            setAnswerFlag(AnswerFlag.VALID);
            setValue(chosenCards);
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(String.format(QUESTION, choices.size() / 2));
        for (int i = 0; i < choices.size(); i++) {
            builder.append(String.format("%d) %s\n", i + 1, choices.get(i).toString()));
        }

        return builder.toString();
    }

    @Override
    public String getAnswer() {
        if (choices.size() == 2)
            return String.format(SINGLE_ANSWER, choices.size());
        return String.format(MULTIPLE_ANSWER, choices.size());
    }
}