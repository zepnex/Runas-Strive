package edu.kit.informatik.model.abilities;

/**
 * This class represents a defensive card.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class DefensiveCard extends Card {
    public static CardType CARD_TYPE = CardType.DEFENSIVE;

    /**
     * The constructor of the DefensiveCard.
     *
     * @param n the ability-level of the card
     */
    public DefensiveCard(int n) {
        super(n);
    }

    /**
     * This method returns the defensive value of the card.
     *
     * @return the defensive value of the card
     */
    public abstract int getDefense();

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }
}
