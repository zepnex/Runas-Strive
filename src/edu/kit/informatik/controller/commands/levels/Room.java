package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.model.enteties.Monster;

import java.util.List;

/**
 * This class represents a room in the game.
 *
 * @author unyrg
 * @version 1.0
 */
public class Room {

    private final List<Monster> monsters;
    private final int stage;

    /**
     *  This Constructor creates a new room.
     *
     * @param monsters the monsters of the room.
     * @param stage   the stage of the level.
     */
    public Room(List<Monster> monsters, int stage) {
        this.monsters = monsters;
        this.stage = stage;
    }

    /**
     * This method removes the dead monsters from the room.
     *
     * @param monster
     */
    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }


    /**
     * This method checks if the player is alive.
     *
     * @return true if the monster is alive
     */
    public boolean monstersAlive() {
        for (Monster monster : this.monsters) {
            if (monster.getCurrentHp() > 0) return true;
        }
        return false;
    }

    /**
     * This method returns the monsters of the room.
     *
     * @return the monsters of the room.
     */
    public List<Monster> getMonsters() {
        return this.monsters;
    }

    /**
     * This method returns the stage of the level.
     *
     * @return the stage of the level
     */
    public int getRoom() {
        return this.stage;
    }
}
