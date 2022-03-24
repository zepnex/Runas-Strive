package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.Session;
import edu.kit.informatik.controller.commands.action.SelectCardRequest;
import edu.kit.informatik.controller.commands.action.TargetRequest;
import edu.kit.informatik.controller.commands.requests.AnswerFlag;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Room {
    private Player player;
    private List<Monster> monsters;
    private final int stage;
    private final Level level;
    private Session session;
    private Monster currentTarget;

    public Room(Session session, Player player, List<Monster> monsters, Level level, int stage) {
        this.session = session;
        this.player = player;
        this.monsters = monsters;
        this.level = level;
        this.stage = stage;
    }

    public void start() {
        printEncounter();
        combat();
    }

    private void combat() {
        while (this.player.getCurrentHp() > 0 && monstersAlive()) {
            selectCard();
            if (this.monsters.size() > 1) selectTarget();

        }
    }


    private void printEncounter() {
        System.out.println("----------------------------------------");
        System.out.printf("Runa enters Stage %d if Level %d\n", stage, level.getLevel());
        System.out.printf("Runa (%d/%d HP, %d/%d FP)\n", this.player.getCurrentHp(), this.player.getMaxHp(),
                this.player.getAbilityLevel(), 6);
        System.out.println("vs.");
        for (Monster monster : monsters) {
            System.out.printf("%s (%d/%d HP, %dFP)\n", monster.getName(), monster.getCurrentHp(), monster.getMaxHp(),
                    monster.getFocusPoints());
        }
        System.out.println("----------------------------------------");
    }


    private void selectCard() {
        SelectCardRequest cardSelection = new SelectCardRequest(this.player.getCards());
        this.session.requestInput(cardSelection);
        if (!cardSelection.getAnswerFlag().equals(AnswerFlag.QUIT))
            this.player.setCurrentAttackCard(cardSelection.getValue());

    }

    private void selectTarget() {
        TargetRequest targetSelection = new TargetRequest(this.monsters);
        this.session.requestInput(targetSelection);
        if (!targetSelection.getAnswerFlag().equals(AnswerFlag.QUIT))
            System.out.println("test");
    }

    private boolean monstersAlive() {
        for (Monster monster : this.monsters) {
            if (monster.getCurrentHp() > 0) return true;
        }
        return false;
    }
}
