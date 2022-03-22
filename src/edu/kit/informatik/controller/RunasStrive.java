package edu.kit.informatik.controller;

import edu.kit.informatik.controller.commands.actions.ShuffleCards;
import edu.kit.informatik.controller.commands.levels.Level;
import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
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
import edu.kit.informatik.model.enteties.monster.Mushroomlin;
import edu.kit.informatik.model.enteties.monster.Mushroomlon;
import edu.kit.informatik.model.enteties.monster.Rat;
import edu.kit.informatik.model.enteties.monster.ShadowBlade;
import edu.kit.informatik.model.enteties.monster.Skeleton;
import edu.kit.informatik.model.enteties.monster.Snake;
import edu.kit.informatik.model.enteties.monster.Spider;
import edu.kit.informatik.model.enteties.monster.Tarantula;
import edu.kit.informatik.model.enteties.monster.WildBoar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class RunasStrive {
    private final Session session;
    private final Player player;
    private Scanner scanner;
    private int level;
    private List<Card> playerCards;
    Queue<List<Monster>> monster;


    public RunasStrive(Session session, Player player) {
        this.session = session;
        this.player = player;

        initCards();
    }


    public void start() {
        this.scanner = new Scanner(System.in);
        // shuffle card
        this.level = 1;
        ShuffleCards shuffle = new ShuffleCards(this);
        boolean satisfied = false;
        shuffle.printQuestion();
        while (!satisfied) {
            shuffle.printAnswer();
            String input = this.scanner.nextLine();
            if (input.equals("quit")) {
                this.session.stop();
                return;
            }
            satisfied = shuffle.apply(input);
        }
        loadLevel();
        this.scanner.close();
    }

    public void loadLevel() {
        while (this.level < 3) {
            new Level(this.player, this.monster.poll(), level, this);
            this.level++;
        }
    }

    public void shuffle(int seedPlayer, int seedMonster) {
        Collections.shuffle(this.playerCards, new Random(seedPlayer));
        Collections.shuffle(this.monster.element(), new Random(seedMonster));
    }

    public void initCards() {
        this.playerCards = new ArrayList<>(List.of(
            new Fire(player.getAbilityLevel()), new Ice(player.getAbilityLevel()),
            new Lightning(player.getAbilityLevel()), new Reflect(player.getAbilityLevel()),
            new Water(player.getAbilityLevel()), new Parry(player.getAbilityLevel()),
            new Slash(player.getAbilityLevel()), new Swing(player.getAbilityLevel()),
            new Thrust(player.getAbilityLevel()), new Focus(player.getAbilityLevel())));
        this.playerCards.removeAll(this.player.getCards());

        this.monster = new LinkedList<>() {{
            add(new ArrayList<>(
                List.of(new Frog(), new Ghost(), new Skeleton(), new Spider(), new Goblin(), new Rat(),
                    new Mushroomlin())) {
            });
            add(new ArrayList<>(
                List.of(new Snake(), new DarkElf(), new ShadowBlade(), new Hornet(), new Tarantula(), new Bear(),
                    new Mushroomlon(), new WildBoar())));
        }};
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void quitGame() {
        this.session.stop();
    }
}
