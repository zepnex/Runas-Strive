package edu.kit.informatik.model.abilities;

/**
 * This class represents a card.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class Card {
    private int abilityLevel;

    /**
     * This class represents a card.
     *
     * @param n the ability level of the card
     */
    public Card(int n) {
        this.abilityLevel = n;
    }

    /**
     * This method returns the name of the card.
     *
     * @return the name of the card
     */
    public abstract String getName();

    /**
     * This method returns the ability level of the card.
     *
     * @return the ability level of the card
     */
    public int getAbilityLevel() {
        return abilityLevel;
    }

    /**
     * This method returns the card-type of the card.
     *
     * @return the card-type of the card
     */
    public abstract CardType getCardType();

    /**
     * This method returns the card-class of the card.
     *
     * @return the card-class of the card
     */
    public abstract CardClass getCardClass();

    /**
     * This methode upgrades the card.
     */
    public void upgradeCard() {
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
