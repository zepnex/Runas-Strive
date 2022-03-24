package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;

import java.util.LinkedList;
import java.util.Queue;

public class ShuffleCardRequest extends InputRequest<Queue<Integer>> {

    private static final String QUESTION = "To shuffle ability cards and monsters, enter two seeds";
    private static final String ANSWER = String.format("Enter number [1--%d]", Integer.MAX_VALUE);
    private static final String MAX_INT_STR = String.valueOf(Integer.MAX_VALUE);
    private static final String REGEX = "^\\d+$";

    @Override
    public void process(String input) {
        String[] seeds = input.split(",");
        Queue<Integer> intSeeds = new LinkedList<>();
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
        } else {
            if (seeds.length == 2) {
                for (String seed : seeds) {
                    if (checkSeed(seed))
                        intSeeds.add(Integer.parseInt(seed));
                    else
                        setAnswerFlag(AnswerFlag.UNUSABLE);
                }
            } else {
                setAnswerFlag(AnswerFlag.UNUSABLE);
            }
            if(intSeeds.size()==2) {
                setAnswerFlag(AnswerFlag.VALID);
                setValue(intSeeds);
            }
        }
    }

    private boolean checkSeed(String seed) {
        if (!seed.matches(REGEX)) return false;
        return seed.compareTo(MAX_INT_STR) <= 0 && seed.compareTo("0") > 0;
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
