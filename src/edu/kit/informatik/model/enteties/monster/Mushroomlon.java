package edu.kit.informatik.model.enteties.monster;



import edu.kit.informatik.model.abilities.monster_abilities.magical.Deflect;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Scratch;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Mushroomlon extends Monster {
    private static final int HP = 50;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Deflect(2), new Scratch(2), new Block(2));
}
