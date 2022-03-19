package edu.kit.informatik.model.enteties.monster;



import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Water;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Frog extends Monster {
    private static final int HP = 16;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.WATER;
    private final static List ABILYTIES = List.of(new Focus(1), new Water(1));

}
