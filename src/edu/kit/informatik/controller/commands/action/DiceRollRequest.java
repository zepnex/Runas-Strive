package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;

public class DiceRollRequest extends InputRequest<Integer> {
    private static final String ANSWER = "Enter dice roll [1--%d]:";
    private static final String REGEX = "[1-%d]";
    int dice;


    public DiceRollRequest(int dice) {
        this.dice = dice;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
        } else {
            if (input.matches(String.format(REGEX, dice))) {
                setAnswerFlag(AnswerFlag.VALID);
                setValue(Integer.parseInt(input));
            } else {
                setAnswerFlag(AnswerFlag.UNUSABLE);
            }
        }
    }

    @Override
    public String getQuestion() {
        return "";
    }

    @Override
    public String getAnswer() {
        return String.format(ANSWER, dice);
    }
}
