package edu.kit.informatik.model.enteties.monster;



import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Claw;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Bear extends Monster {
    private static final int HP = 40;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Claw(2), new Scratch(2), new Block(2));
}
