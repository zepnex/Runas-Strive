package edu.kit.informatik.model.abilities;

public abstract class OffensiveCard extends Card {
    public static CardType CARD_TYPE = CardType.OFFENSIVE;
    private final int cost;


    public OffensiveCard(int n) {
        super(n);
        this.cost = n;
    }

    public abstract int getDamage(int n, int w);


    public int getCost() {
        return cost;
    }

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }
}
