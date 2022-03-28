package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents a Pierce card.
 *
 * @author unryg
 * @version 1.0
 */
public class Pierce extends OffensiveCard {
    private static final String CARD_NAME = "Pierce";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;
    private static final int COST = 0;

    /**
     * The constructor of the Pierce class.
     *
     * @param n the ability level of the card
     */
    public Pierce(int n) {
        super(n);

    }

    @Override
    public int getDamage(int w) {
        return (7 * this.getAbilityLevel() + w) + (w > 5 ? 5 * this.getAbilityLevel() : 0);
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
