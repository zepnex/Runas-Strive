package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.Session;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;
import edu.kit.informatik.model.enteties.monster.SpiderKing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level {
    private final Player player;
    private final Session session;
    private final List<Monster> monster;
    Queue<Room> rooms;
    private final int level;


    public Level(Player player, List<Monster> monster, int level, Session session) {
        this.monster = monster;
        this.player = player;
        this.level = level;
        this.session = session;
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
            rooms.add(new Room(this.player, roomMonster, this, (int) i));
        }
        rooms.add(new Room(this.player, new ArrayList<>(List.of(new SpiderKing())), this, 4));
        return rooms;
    }

    public Room loadRoom() {
        return this.rooms.poll();
    }

    public int getLevel() {
        return level;
    }


}
