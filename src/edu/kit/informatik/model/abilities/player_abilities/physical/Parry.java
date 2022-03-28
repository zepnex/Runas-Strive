package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.DefensiveCard;

/**
 * This class represents a Parry card.
 *
 * @author unryg
 * @version 1.0
 */
public class Parry extends DefensiveCard {
    private static final String CARD_NAME = "Parry";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    /**
     * The constructor of the Parry class.
     *
     * @param n the ability level of the Parry card
     */
    public Parry(int n) {
        super(n);
    }

    @Override
    public int getDefense() {
        return 7 * this.getAbilityLevel();
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
