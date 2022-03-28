package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents an offensive card.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class OffensiveCard extends Card {
    private static final CardType CARD_TYPE = CardType.OFFENSIVE;
    private int cost;

    /**
     * This constructor creates a new offensive card.
     *
     * @param n the ability-level of the card
     */
    public OffensiveCard(int n) {
        super(n);
    }

    /**
     * @param factor the dice value of the user
     * @return the damage the card does
     */
    public abstract int getDamage(int factor);


    @Override
    public CardType getCardType() {
        return CARD_TYPE;
    }

    /**
     * This method checks if a card breaks the focus of the enemy.
     *
     * @return true if the card breaks the focus, false otherwise
     */
    public boolean breaksFocus() {
        return false;
    }

    /**
     * This method checks if the current card is effective against a monster.
     *
     * @param monsterType the monster type
     * @return true if the card is effective, false otherwise
     */
    public abstract boolean isEffectiveOn(MonsterType monsterType);
}
