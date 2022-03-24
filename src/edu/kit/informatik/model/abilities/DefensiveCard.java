package edu.kit.informatik.model.abilities;

public abstract class DefensiveCard extends Card {
    public static CardType CARD_TYPE = CardType.DEFENSIVE;

    public DefensiveCard(int n) {
        super(n);
    }

    public abstract int getDefense(int n);

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }
}
