package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.RunasStrive;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public abstract class Level {
    RunasStrive game;
    Player player;
    List<Card> playeCards;
    List<Monster> monsterCards;


    public Level(RunasStrive game, Player player, List<Card> playerCards, List<Monster> monsterCards) {
        this.game = game;
        this.player = player;
        this.playeCards = playerCards;
        this.monsterCards = monsterCards;


    }

    abstract void startLevel();

    boolean checkQuit(String input) {
        return input.equals("quit");
    }


}
