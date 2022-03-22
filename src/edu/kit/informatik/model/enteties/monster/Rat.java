package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Claw;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Rat extends Monster {
    private static final int MAX_HP = 14;
    private static final String NAME = "Rat";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Block(1), new Claw(1));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
