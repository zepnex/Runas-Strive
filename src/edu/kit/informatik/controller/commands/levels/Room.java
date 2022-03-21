package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Room {
    Player player;
    List<Monster> monsters;

    public Room(Player player, List<Monster> monsters) {
        this.player = player;
        this.monsters = monsters;
    }

    public void start() {

    }

}
