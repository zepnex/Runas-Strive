package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Mushroomlin extends Monster {
    private static final int MAX_HP = 20;
    private static final String NAME = "Mushroomlin";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static Queue<Card> ABILITIES
        = new LinkedList<>(List.of(new Deflect(1), new Scratch(1)));


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
