package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.actions.ShuffleCards;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.controller.commands.levels.Level1;
import edu.kit.informatik.controller.commands.levels.Level2;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.player_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.player_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.player_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.player_abilities.magical.Reflect;
import edu.kit.informatik.model.abilities.player_abilities.magical.Water;
import edu.kit.informatik.model.abilities.player_abilities.physical.Parry;
import edu.kit.informatik.model.abilities.player_abilities.physical.Slash;
import edu.kit.informatik.model.abilities.player_abilities.physical.Swing;
import edu.kit.informatik.model.abilities.player_abilities.physical.Thrust;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.Player;
import edu.kit.informatik.model.enteties.monster.Bear;
import edu.kit.informatik.model.enteties.monster.DarkElf;
import edu.kit.informatik.model.enteties.monster.Frog;
import edu.kit.informatik.model.enteties.monster.Ghost;
import edu.kit.informatik.model.enteties.monster.Goblin;
import edu.kit.informatik.model.enteties.monster.Hornet;
import edu.kit.informatik.model.enteties.monster.MegaSaurus;
import edu.kit.informatik.model.enteties.monster.Mushroomlin;
import edu.kit.informatik.model.enteties.monster.Mushroomlon;
import edu.kit.informatik.model.enteties.monster.Rat;
import edu.kit.informatik.model.enteties.monster.ShadowBlade;
import edu.kit.informatik.model.enteties.monster.Skeleton;
import edu.kit.informatik.model.enteties.monster.Snake;
import edu.kit.informatik.model.enteties.monster.Spider;
import edu.kit.informatik.model.enteties.monster.SpiderKing;
import edu.kit.informatik.model.enteties.monster.Tarantula;
import edu.kit.informatik.model.enteties.monster.WildBoar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class RunasStrive {
    private Session session;
    private final Player player;
    private final Scanner scanner;
    private int level;
    private List<Card> playerCards;
    private List<Monster> monsterLevel1;
    List<Monster> monsterLevel2;
    Level currentLevel;


    public RunasStrive(Session session, Player player, Scanner scanner) {
        this.session = session;
        this.player = player;
        this.scanner = scanner;
        loadLevel(level);
    }


    public void start() {
        // shuffle card
        this.level = 1;
        ShuffleCards shuffel = new ShuffleCards(this);
        boolean satisfied = false;
        shuffel.printQuestion();
        while (!satisfied) {
            shuffel.printAnswer();
            satisfied = shuffel.apply(scanner.nextLine());
        }
        loadLevel(level);
    }

    public void loadLevel(int level) {
        if (level == 1) {
            currentLevel = new Level1(this, this.player, this.playerCards, this.monsterLevel1);
        } else if (level == 2) {
            currentLevel = new Level2(this, this.player, this.playerCards, this.monsterLevel2);
        } else {
            //Game is finished
        }

    }

    public void initCards(Queue<Integer> seeds) {
        this.playerCards = new ArrayList<>(List.of(
            new Fire(player.getAbilityLevel()), new Ice(player.getAbilityLevel()),
            new Lightning(player.getAbilityLevel()), new Reflect(player.getAbilityLevel()),
            new Water(player.getAbilityLevel()), new Parry(player.getAbilityLevel()),
            new Slash(player.getAbilityLevel()), new Swing(player.getAbilityLevel()),
            new Thrust(player.getAbilityLevel())));
        Collections.shuffle(this.playerCards, new Random(seeds.peek()));
        if (level == 1) {
            this.monsterLevel1 =
                new ArrayList<>(
                    List.of(new SpiderKing(), new Frog(), new Ghost(), new Skeleton(), new Spider(), new Goblin(),
                        new Rat(), new Mushroomlin()));
            Collections.shuffle(this.monsterLevel1, new Random(seeds.peek()));
        } else {
            this.monsterLevel2 = new ArrayList<>(
                List.of(new MegaSaurus(), new Snake(), new DarkElf(), new ShadowBlade(), new Hornet(),
                    new Tarantula(), new Bear(), new Mushroomlon(), new WildBoar()));
            Collections.shuffle(monsterLevel2, new Random(seeds.peek()));
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
