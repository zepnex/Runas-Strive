package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.enteties.MonsterType;

public abstract class OffensiveCard extends Card {
    public static CardType CARD_TYPE = CardType.OFFENSIVE;
    private int cost;


    public OffensiveCard(int n) {
        super(n);
    }

    public abstract int getDamage(int n, int factor);

    protected void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }

    public boolean breaksFocus() {
        return false;
    }


    public abstract boolean isEffectiveOn(MonsterType monsterType);
}
