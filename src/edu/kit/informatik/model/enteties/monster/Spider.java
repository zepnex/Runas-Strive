package edu.kit.informatik.model.enteties.monster;



import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class Spider extends Monster {
    private static final int HP = 15;
    private static final boolean BOSS = false;
    private static final MonsterType TYPE = MonsterType.NORMAL;
    private final static List ABILYTIES = List.of(new Bite(1), new Block(1));
}
