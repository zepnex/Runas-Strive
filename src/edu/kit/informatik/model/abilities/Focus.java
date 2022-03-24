package edu.kit.informatik.model.abilities;

public class Focus extends Card {
    private static final String CARD_NAME = "Focus";
    private static final CardType CARD_TYPE = CardType.NONE;
    private static final CardClass CARD_CLASS = CardClass.NONE;

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
