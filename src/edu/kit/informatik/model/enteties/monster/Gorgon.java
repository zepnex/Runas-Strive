package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Fire;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Gorgon extends Monster {
    private static final int MAX_HP = 13;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.FIRE;
    private final static List ABILYTIES = List.of(new Focus(1), new Fire(1));

    @Override
    protected int getMaxHp() {
        return MAX_HP;
    }
}
