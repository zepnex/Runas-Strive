package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Room {
    private final Player player;
    private final List<Monster> monsters;
    private final int stage;
    private final Level level;

    public Room(Player player, List<Monster> monsters, Level level, int stage) {
        this.player = player;
        this.monsters = monsters;
        this.level = level;
        this.stage = stage;
    }

    public void printIntro() {
        System.out.printf("Runa enters Stage %d of Level %d\n", stage, level.getLevel());
    }

    public void printEncounter() {
        System.out.println("----------------------------------------");
        System.out.printf("Runa (%d/%d HP, %d/%d FP)\n", this.player.getCurrentHp(), this.player.getMaxHp(),
                this.player.getFocusPoints(), this.player.getDice());
        System.out.println("vs.");
        for (Monster monster : monsters) {
            System.out.printf("%s (%d HP, %d FP): attempts %s next\n", monster.getName(), monster.getCurrentHp(),
                    monster.getFocusPoints(), monster.getAbilities().element().toString());
        }
        System.out.println("----------------------------------------");
    }


    public boolean monstersAlive() {
        for (Monster monster : this.monsters) {
            if (monster.getCurrentHp() > 0) return true;
        }
        return false;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
