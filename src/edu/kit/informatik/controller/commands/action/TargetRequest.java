package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.enteties.Monster;

import java.util.List;

public class TargetRequest extends InputRequest<Monster> {
    private static final StringBuilder QUESTION = new StringBuilder("Select Runa's target\n");
    private static final String ANSWER = "Enter number [1--%d]";
    private static final String REGEX = "[1-%d]";
    private final List<Monster> monsters;

    public TargetRequest(List<Monster> monsters) {
        this.monsters = monsters;
    }

    @Override
    public void process(String input) {
        if (input.equals("quit")) setAnswerFlag(AnswerFlag.QUIT);
        else if (input.matches(String.format(REGEX, monsters.size()))) {
            setAnswerFlag(AnswerFlag.VALID);
            setValue(this.monsters.get(Integer.parseInt(input) - 1));
        } else {
            setAnswerFlag(AnswerFlag.UNUSABLE);
        }
    }

    @Override
    public String getQuestion() {
        for (int i = 0; i < this.monsters.size(); i++) {
            QUESTION.append(String.format("%d) %s \n", i + 1, this.monsters.get(i).getName()));
        }
        return QUESTION.substring(0, QUESTION.length() - 2);
    }

    @Override
    public String getAnswer() {
        return String.format(ANSWER, this.monsters.size());
    }
}
