package edu.kit.informatik.model.abilities.monster_abilities.magical;

import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents a lightning card.
 *
 * @author unryg
 * @version 1.0
 */
public class Lightning extends OffensiveCard {
    private static final String CARD_NAME = "Lightning";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;

    /**
     * Constructor for the Lightning class.
     *
     * @param n the ability level of the card
     */
    public Lightning(int n) {
        super(n);
    }


    @Override
    public int getDamage(int w) {
        return 14 * this.getAbilityLevel() + 2;
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
