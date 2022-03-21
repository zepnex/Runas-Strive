package edu.kit.informatik.controller.commands.levels;

import edu.kit.informatik.controller.RunasStrive;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;

import java.util.List;

public class Level1 extends Level {
    private int stage = 1;

    public Level1(RunasStrive game, Player player, List<Card> playerCards, List<Monster> monsterCards) {
        super(game, player, playerCards, monsterCards);
        startLevel();
    }

    @Override
    void startLevel() {
        System.out.printf("Runa enters Stage %d of Level %d", stage, game.getLevel());
    }


    @Override
    boolean checkQuit(String input) {
        return super.checkQuit(input);
    }

}
