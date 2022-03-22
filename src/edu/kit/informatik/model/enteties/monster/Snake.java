package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Ice;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Snake extends Monster {
    private static final int MAX_HP = 31;
    private static final String NAME = "Snake";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.ICE;
    private final static List ABILYTIES = List.of(new Bite(2), new Focus(2), new Ice(2));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
