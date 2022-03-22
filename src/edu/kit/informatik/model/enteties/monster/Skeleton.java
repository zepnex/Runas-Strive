package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Lightning;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Skeleton extends Monster {
    private static final int MAX_HP = 14;
    private static final String NAME = "Skeleton";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.LIGHTNING;
    private final static List ABILYTIES = List.of(new Focus(1), new Lightning(1));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
