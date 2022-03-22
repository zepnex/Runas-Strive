package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class WildBoar extends Monster {
    private static final int MAX_HP = 27;
    private static final String NAME = "Wild Boar";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Scratch(2), new Deflect(2), new Scratch(2));


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
