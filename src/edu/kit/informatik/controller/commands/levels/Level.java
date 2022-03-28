package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.monster.MegaSaurus;
import edu.kit.informatik.model.enteties.monster.SpiderKing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a level.
 *
 * @author unyrg
 * @version 1.0
 */
public class Level {
    private static final int BOSS_ROOM = 4;
    private final List<Monster> monster;
    private final Queue<Room> rooms;
    private final int level;

    /**
     * This constructor creates a new level.
     *
     * @param monster the monsters for the level
     * @param level   the level-index
     */
    public Level(List<Monster> monster, int level) {
        this.monster = monster;
        this.level = level;
        this.rooms = initRooms();
    }

    private Queue<Room> initRooms() {
        Queue<Room> rooms = new LinkedList<>(List.of());
        for (double i = 1; i < 4; i++) {
            List<Monster> roomMonster = new ArrayList<>();
            for (int j = 1; j <= Math.ceil((i + 1) / 2); j++) {
                roomMonster.add(this.monster.get(0));
                this.monster.remove(0);
            }
            rooms.add(new Room(roomMonster, (int) i));
        }
        if (level == 1)
            rooms.add(new Room(new ArrayList<>(List.of(new SpiderKing())), BOSS_ROOM));
        else
            rooms.add(new Room(new ArrayList<>(List.of(new MegaSaurus())), BOSS_ROOM));
        return rooms;
    }

    /**
     * This method returns the next room.
     *
     * @return the next room
     */
    public Room loadRoom() {
        return this.rooms.poll();
    }

    /**
     * This method returns the level-index.
     *
     * @return the level-index
     */
    public int getLevel() {
        return level;
    }

    /**
     * This method returns the number of rooms.
     *
     * @return the number of rooms
     */
    public int getRoomCount() {
        return BOSS_ROOM;
    }


}
