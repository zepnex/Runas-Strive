package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

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

    public abstract MonsterType getMonsterType();
}
