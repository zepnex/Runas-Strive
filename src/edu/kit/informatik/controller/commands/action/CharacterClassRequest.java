package edu.kit.informatik.controller.commands.action;

import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.controller.commands.requests.InputRequest;
import edu.kit.informatik.model.enteties.CharacterClass;

public class CharacterClassRequest extends InputRequest<CharacterClass> {
    private static final String QUESTION = "Select Runa's character class\n";
    private static final String ANSWER = String.format("Enter number [1--%s]:", CharacterClass.values().length);
    private static final String REGEX = String.format("[1-%d]", CharacterClass.values().length);

    @Override
    public void process(String input) {
        if (input.equals("quit")) {
            setAnswerFlag(AnswerFlag.QUIT);
        } else {
            if (input.matches(REGEX)) {
                setAnswerFlag(AnswerFlag.VALID);
                setValue(CharacterClass.getCharacter(Integer.parseInt(input)));
            } else {
                setAnswerFlag(AnswerFlag.UNUSABLE);
            }
        }
    }

    @Override
    public String getQuestion() {
        StringBuilder builder = new StringBuilder(QUESTION);
        for (CharacterClass characterClass : CharacterClass.values()) {
            String name = characterClass.toString();
            builder.append(String.format(
                    "%d) %s\n", characterClass.getCharID(), name.charAt(0) + name.substring(1).toLowerCase()));

        }
        return builder.toString();
    }

    @Override
    public String getAnswer() {
        return ANSWER;
    }


}
