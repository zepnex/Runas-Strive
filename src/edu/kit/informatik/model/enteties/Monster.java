package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

import java.util.Queue;

public abstract class Monster extends Entity {
    private static final int FOCUS_POINTS = 0;

    public Monster() {
        super(FOCUS_POINTS);
    }

    public abstract Queue<Card> getAbilities();

}
