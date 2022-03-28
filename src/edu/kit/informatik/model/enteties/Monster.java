package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

import java.util.Queue;

public abstract class Monster extends Entity {
    private static final int FOCUS_POINTS = 0;

    public Monster() {
        super(FOCUS_POINTS);
        setMaxFocusPoint(Integer.MAX_VALUE);
    }

    public abstract Queue<Card> getAbilities();

    public Card getCard() {

        Card card = getAbilities().poll();
        setCurrentCard(card);
        getAbilities().add(card);
        return card;
    }

    public void nextPossibleCard() {
        if (getCurrentCard().getCardType().equals(CardType.OFFENSIVE)) {
            OffensiveCard attack = (OffensiveCard) getCurrentCard();
            if (attack.getCardClass() == CardClass.MAGICAL&& this.getFocusPoints() < attack.getAbilityLevel()) {
                getCard();
                nextPossibleCard();
            }
        }
    }

    public abstract MonsterType getMonsterType();
}
