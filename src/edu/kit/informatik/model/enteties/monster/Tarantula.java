package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a Tarantula monster.
 *
 * @author unyrg
 * @version 1.0
 */
public class Tarantula extends Monster {
    private static final int MAX_HP = 33;
    private static final String NAME = "Tarantula";
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private static final Queue<Card> ABILITIES
            = new LinkedList<>(List.of(new Bite(2), new Block(2), new Scratch(2)));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public Queue<Card> getAbilities() {
        return ABILITIES;
    }

    @Override
    public MonsterType getMonsterType() {
        return TYPE;
    }
}
