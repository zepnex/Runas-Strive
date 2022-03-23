package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.commands.Choosable;
import edu.kit.informatik.controller.commands.actions.CombatRound;
import edu.kit.informatik.controller.commands.actions.SelectCard;
import edu.kit.informatik.controller.commands.actions.SelectTarget;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;
import java.util.Scanner;

public class Room {
    private Player player;
    private List<Monster> monsters;
    private final int stage;
    private final Level level;
    private Scanner scanner;
    private Monster currentTarget;

    public Room(Player player, List<Monster> monsters, Level level, int stage) {
        this.player = player;
        this.monsters = monsters;
        this.level = level;
        this.stage = stage;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // printEncounter();
        combat();
    }

    public void combat() {
        while (this.player.getCurrentHp() > 0) {
            printEncounter();
            doSomething(new SelectCard(this.player));
            if (this.monsters.size() > 1) doSomething(new SelectTarget(this.monsters, this));
            else this.currentTarget = monsters.get(0);
            doSomething(new CombatRound(this.player, this.monsters, this.currentTarget));
        }
    }

    private void doSomething(Choosable action) {
        action.printQuestion();
        action.printAnswer();

        boolean satisfied = false;
        while (!satisfied) {
            action.printChoices();
            String input = this.scanner.nextLine();
            if (checkQuit(input)) {
                //TODO: somehow make this working
                level.quitGame();
                return;
            }
            satisfied = action.apply(input);
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

    private boolean checkQuit(String input) {
        return input.equals("quit");
    }

    public void setTarget(Monster currentTarget) {
        this.currentTarget = currentTarget;
    }
}
