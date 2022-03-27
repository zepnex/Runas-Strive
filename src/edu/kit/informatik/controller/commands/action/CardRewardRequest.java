package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.abilities.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardRewardRequest extends InputRequest<List<Card>> {
    private static final String QUESTION = "Pick %d card(s) as loot\n";
    private static final String MULTIPLE_ANSWER = "Enter numbers [1--%d] separated by comma:";
    private static final String SINGLE_ANSWER = "Enter number [1--%d]:";
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
        String[] answer = input.split(",");

        if (answer.length == Math.ceil(choices.size() / 2d) && !input.endsWith(",")) {
            if (validInput(answer)) {
                for (String number : answer) {
                    chosenCards.add(choices.get(Integer.parseInt(number) - 1));
                }
                setAnswerFlag(AnswerFlag.VALID);
                setValue(chosenCards);
            } else {
                setAnswerFlag(AnswerFlag.UNUSABLE);
            }
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
    }

    private boolean validInput(String[] input) {
        //check for same number of input
        try {
            Set<Integer> set = new HashSet<>();
            for (String s : input) {
                int number = Integer.parseInt(s);
                if (!(number > 0 && number <= choices.size()) || set.contains(number)) {

                    return false;
                }
                set.add(number);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(String.format(QUESTION, (int) Math.ceil(choices.size() / 2d)));
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