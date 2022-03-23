package edu.kit.informatik.controller.commands.actions;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.controller.commands.levels.Room;
import edu.kit.informatik.model.enteties.Monster;

import java.util.List;

public class SelectTarget extends Choosable {
    private static final String QUESTION = "Select Runa's Target";
    private List<Monster> answers;
    private Room room;

    public SelectTarget(List<Monster> answers, Room room) {
        this.answers = answers;
        this.room = room;
    }

    @Override
    public void printQuestion() {
        System.out.println(QUESTION);
    }

    @Override
    public void printAnswer() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.answers.size(); i++) {
            Monster monster = this.answers.get(i);
            builder.append(String.format("%d) %s\n", i + 1, monster.getName()));
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }

    @Override
    public void printChoices() {
        System.out.printf("Enter number [1--%s]\n", this.answers.size());
    }

    @Override
    public void execute(String input) {
        //TODO: do something
        this.room.setTarget(this.answers.get(Integer.parseInt(input) - 1));
    }

    @Override
    public boolean apply(String input) {
        if(input.matches("[1-2]")){
            execute(input);
            return true;
        }
        return false;
    }
}
