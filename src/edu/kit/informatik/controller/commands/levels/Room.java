package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Room {
    private final Player player;
    private final List<Monster> monsters;
    private final int stage;
    private final Level level;
    private Monster toRemove;

    public Room(Player player, List<Monster> monsters, Level level, int stage) {
        this.player = player;
        this.monsters = monsters;
        this.level = level;
        this.stage = stage;
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }


    public boolean monstersAlive() {
        for (Monster monster : this.monsters) {
            if (monster.getCurrentHp() > 0) return true;
        }
        return false;
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }
}
