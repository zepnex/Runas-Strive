package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Claw;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bear extends Monster {
    private static final int MAX_HP = 40;
    private static final String NAME = "Bear";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private static final int ABILITY_LEVEL = 2;
    private static final Queue<Card> ABILITIES
            = new LinkedList<>(List.of(new Claw(2), new Deflect(2), new Block(2)));


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
