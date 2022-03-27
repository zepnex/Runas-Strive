package edu.kit.informatik.model.abilities;


public abstract class Card {
    private int abilityLevel;

    public Card(int n) {
        this.abilityLevel = n;
    }

    public abstract String getName();

    public int getAbilityLevel() {
        return abilityLevel;
    }

    public abstract CardType getCardType();

    public abstract CardClass getCardClass();

    public void upgradeCard(){
        this.abilityLevel++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;
        return this.getName().equals(card.getName());
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getName(), abilityLevel);
    }
}
