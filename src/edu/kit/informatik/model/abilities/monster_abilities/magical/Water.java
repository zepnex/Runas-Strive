package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;


    public Water(int n) {
        super(n);
        setCost(COST);
    }

    @Override
    public int getDamage(int w) {
        return 8 * this.getAbilityLevel() + 2;
    }

    @Override
    public boolean isEffectiveOn(MonsterType monsterType) {
        return false;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }

    @Override
    public CardClass getCardClass() {
        return CARD_CLASS;
    }


}
