package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hornet extends Monster {
    private static final int MAX_HP = 32;
    private static final String NAME = "Hornet";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.FIRE;
    private final static Queue<Card> ABILITIES
        = new LinkedList<>(List.of(new Scratch(2), new Focus(2), new Fire(1), new Fire(2)));


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
