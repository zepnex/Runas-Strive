package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Smash;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a Goblin monster.
 *
 * @author unyrg
 * @version 1.0
 */
public class Goblin extends Monster {
    private static final int MAX_HP = 12;
    private static final String NAME = "Goblin";
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private static final Queue<Card> ABILITIES
            = new LinkedList<>(List.of(new Smash(1), new Deflect(1)));


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
