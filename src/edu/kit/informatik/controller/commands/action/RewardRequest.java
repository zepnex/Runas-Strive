package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.controller.commands.requests.Reward;

/**
 * This class represents a request to the server to reward the player.
 *
 * @author unyrg
 * @version 1.0
 */
public class RewardRequest extends InputRequest<Reward> {
    private static final String QUESTION = "Choose Runa's reward\n";
    private static final String ANSWER = "Enter number [1--2]:";
    private static final String REGEX = "[1-2]";

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
        } else {
            if (input.matches(REGEX)) {
                setAnswerFlag(AnswerFlag.VALID);
                setValue(Reward.values()[Integer.parseInt(input) - 1]);
            } else {
                setAnswerFlag(AnswerFlag.INVALID);

            }
        }
    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(QUESTION);
        for (int i = 0; i < Reward.values().length; i++) {
            builder.append(String.format("%d) %s\n", i + 1, Reward.values()[i].getReward()));
        }
        return builder.toString();
    }

    @Override
    public String getAnswer() {
        return ANSWER;
    }
}
