package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpiderKing extends Monster {
    private static final int MAX_HP = 50;
    private static final String NAME = "Spider King";
    private static final boolean BOSS = true;
    private static final MonsterType TYPE = MonsterType.LIGHTNING;
    private final static Queue<Card> ABILITIES
        = new LinkedList(List.of(new Bite(1), new Block(1), new Focus(1), new Lightning(1)));


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
