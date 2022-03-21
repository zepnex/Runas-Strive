package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.RunasStrive;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Level2 extends Level {
    public Level2(RunasStrive game, Player player, List<Card> playerCards, List<Monster> monsterCards) {
        super(game, player, playerCards, monsterCards);
    }

    @Override
    void startLevel() {

    }

    @Override
    boolean checkQuit(String input) {
        return super.checkQuit(input);
    }
}
