package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.Session;
import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.model.enteties.Player;
import edu.kit.informatik.model.enteties.PlayerClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlayerCreation extends Choosable {
    private static final String QUESTION = "Select Runa's character class";
    List<PlayerClass> answers;
    Session session;

    public PlayerCreation(Session session) {
        this.session = session;
        this.answers = new ArrayList<>();
        answers.addAll(Arrays.asList(PlayerClass.values()));
    }

    @Override
    public void printQuestion() {
        System.out.println(QUESTION);
    }

    @Override
    public void printAnswer() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.answers.size(); i++) {
            String answer = this.answers.get(i).toString();

            builder.append(String.format("%d) %s \n", i + 1, answer.charAt(0) + answer.substring(1).toLowerCase()));
        }
        System.out.println(builder.substring(0,builder.length() - 2));
    }

    @Override
    public void printChoices() {
        System.out.printf("Choose number [1--%d]%n", this.answers.size());
    }

    @Override
    public void execute(String input) {
        session.setPlayer(new Player(PlayerClass.getCharacter(Integer.parseInt(input))));
    }

    @Override
    public boolean apply(String input) {
        if (input.matches("[1-3]")) {
            execute(input);
            return true;
        }
        return false;
    }
}
