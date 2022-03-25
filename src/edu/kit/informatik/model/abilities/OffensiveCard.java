package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.enteties.MonsterType;

public abstract class OffensiveCard extends Card {
    public static CardType CARD_TYPE = CardType.OFFENSIVE;
    private final int cost;


    public OffensiveCard(int n) {
        super(n);
        this.cost = n;
    }

    public abstract int getDamage(int n, int factor);


    public int getCost() {
        return cost;
    }

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }

    public abstract boolean isEffectiveOn(MonsterType monsterType);
}
