package edu.kit.informatik.model.abilities;

/**
 * This class represents the ability to focus.
 *
 * @author unyrg
 * @version 1.0
 */
public class Focus extends Card {
    private static final String CARD_NAME = "Focus";
    private static final CardType CARD_TYPE = CardType.NONE;
    private static final CardClass CARD_CLASS = CardClass.NONE;

    /**
     * This constructor creates a new Focus card.
     *
     * @param n the ability-level of the card
     */
    public Focus(int n) {
        super(n);
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }

    @Override
    public CardClass getCardClass() {
        return CARD_CLASS;
    }


}
