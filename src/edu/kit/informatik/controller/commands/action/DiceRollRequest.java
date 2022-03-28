package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;

/**
 * This class represents a request to roll the dice.
 *
 * @author unyrg
 * @version 1.0
 */
public class DiceRollRequest extends InputRequest<Integer> {
    private static final String ANSWER = "Enter dice roll [1--%d]:";
    private final int dice;

    /**
     * The constructor for the DiceRollRequest.
     *
     * @param dice current dice
     */
    public DiceRollRequest(int dice) {
        this.dice = dice;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
            return;
        }
        if (validInput(input)) {
            setAnswerFlag(AnswerFlag.VALID);
            setValue(Integer.parseInt(input));
        } else {
            setAnswerFlag(AnswerFlag.INVALID);
        }
    }

    /**
     * Checks if the input is a valid dice roll.
     *
     * @param input the input to check
     * @return true if the input is a valid dice roll, false otherwise
     */
    private boolean validInput(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0 && number <= dice) return true;
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
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
