package edu.kit.informatik.model.enteties.monster;

import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Water;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class DarkElf extends Monster {
    private static final int MAX_HP = 34;
    private static final String NAME = "Dark Elf";
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Focus(2), new Water(1), new Lightning(1));



    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }
}
