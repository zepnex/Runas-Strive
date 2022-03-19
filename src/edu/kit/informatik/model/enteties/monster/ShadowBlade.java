package edu.kit.informatik.model.enteties.monster;



import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class ShadowBlade extends Monster {
    private static final int HP = 27;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.LIGHTNING;
    private final static List ABILYTIES = List.of(new Scratch(2), new Focus(2), new Lightning(2));
}
