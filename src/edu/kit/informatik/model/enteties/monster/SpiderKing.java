package edu.kit.informatik.model.enteties.monster;


import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster_abilities.magical.Lightning;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Bite;
import edu.kit.informatik.model.abilities.monster_abilities.physical.Block;
import edu.kit.informatik.model.enteties.Monster;
import edu.kit.informatik.model.enteties.MonsterType;

import java.util.List;

public class SpiderKing extends Monster {
    private static final int HP = 50;
    private static final boolean BOSS = true;
    private static final MonsterType TYPE = MonsterType.LIGHTNING;
    private final static List ABILYTIES = List.of(new Bite(1), new Block(1), new Focus(1), new Lightning(1));

}
