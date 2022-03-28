package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

import java.util.Queue;

/**
 * This class represents a monster in the game.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class Monster extends Entity {
    private static final int FOCUS_POINTS = 0;

    /**
     * The constructor of the monster.
     */
    public Monster() {
        super(FOCUS_POINTS);
        setMaxFocusPoint(Integer.MAX_VALUE);
    }

    /**
     * This method returns the monster's abilities.
     *
     * @return the monster's abilities
     */
    public abstract Queue<Card> getAbilities();

    /**
     * This method returns the monster's current card.
     *
     * @return the monster's current card
     */
    public Card getCard() {

        Card card = getAbilities().poll();
        setCurrentCard(card);
        getAbilities().add(card);
        return card;
    }

    /**
     * This method draws the monster's next card.
     */
    public void nextPossibleCard() {
        if (getCurrentCard().getCardType().equals(CardType.OFFENSIVE)) {
            OffensiveCard attack = (OffensiveCard) getCurrentCard();
            if (attack.getCardClass() == CardClass.MAGICAL && this.getFocusPoints() < attack.getAbilityLevel()) {
                getCard();
                nextPossibleCard();
            }
        }
    }

    /**
     * This method returns the monster's type.
     *
     * @return the monster's type
     */
    public abstract MonsterType getMonsterType();
}
