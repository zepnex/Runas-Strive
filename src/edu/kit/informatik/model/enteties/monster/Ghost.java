package edu.kit.informatik.model.enteties.monster;

import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Ice;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Ghost extends Monster {
    private static final int MAX_HP = 15;
    private static final String NAME = "Ghost";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.ICE;
    private final static List ABILYTIES = List.of(new Focus(1), new Ice(1));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
