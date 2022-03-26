package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;

import java.util.LinkedList;
import java.util.Queue;

public class ShuffleCardRequest extends InputRequest<Queue<Integer>> {

    private static final String QUESTION = "To shuffle ability cards and monsters, enter two seeds\n";
    private static final String ANSWER = String.format("Enter seeds [1--%d] separated by comma:", Integer.MAX_VALUE);

    @Override
    public void process(String input) {
        String[] seeds = input.split(",");
        Queue<Integer> intSeeds = new LinkedList<>();
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
            return;
        }
        if(input.endsWith(",")) {
            setAnswerFlag(AnswerFlag.UNUSABLE);
            return;
        }
        if (seeds.length == 2) {
            for (String seed : seeds) {
                try {
                    int number = Integer.parseInt(seed);
                    if (number > 0)
                        intSeeds.add(number);
                } catch (NumberFormatException e) {
                    setAnswerFlag(AnswerFlag.UNUSABLE);
                }
            }
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
            return;
        }
        if (intSeeds.size() == 2) {
            setAnswerFlag(AnswerFlag.VALID);
            setValue(intSeeds);
        }
    }


    @Override
    public String getQuestion() {
        return QUESTION;
    }

    @Override
    public String getAnswer() {
        return ANSWER;
    }
}
