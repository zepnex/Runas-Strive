package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Fire;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents a Gorgon monster.
 *
 * @author unyrg
 * @version 1.0
 */

public class Gorgon extends Monster {
    private static final int MAX_HP = 13;
    private static final String NAME = "Gorgon";
    private static final MonsterType TYPE = MonsterType.FIRE;
    private static final Queue<Card> ABILITIES
            = new LinkedList<>(List.of(new Focus(1), new Fire(1)));


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
