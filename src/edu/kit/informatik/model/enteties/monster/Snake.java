package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a Snake monster.
 *
 * @author unyrg
 * @version 1.0
 */
public class Snake extends Monster {
    private static final int MAX_HP = 31;
    private static final String NAME = "Snake";
    private static final MonsterType TYPE = MonsterType.ICE;
    private static final Queue<Card> ABILITIES
            = new LinkedList<>(List.of(new Bite(2), new Focus(2), new Ice(2)));


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
