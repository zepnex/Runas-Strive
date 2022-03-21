package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Fire;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Hornet extends Monster {
    private static final int MAX_HP = 32;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.FIRE;
    private final static List ABILYTIES = List.of(new Bite(2), new Focus(2), new Fire(1), new Fire(2));

    @Override
    protected int getMaxHp() {
        return MAX_HP;
    }
}
