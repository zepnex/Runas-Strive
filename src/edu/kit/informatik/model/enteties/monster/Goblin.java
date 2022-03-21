package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Smash;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Goblin extends Monster {
    private static final int MAX_HP = 12;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Smash(1), new Deflect(1));

    @Override
    protected int getMaxHp() {
        return MAX_HP;
    }
}
