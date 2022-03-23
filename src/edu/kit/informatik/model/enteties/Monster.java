package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

import java.util.Queue;

public abstract class Monster extends Entity {
    public abstract Queue<Card> getAbilities();

}
