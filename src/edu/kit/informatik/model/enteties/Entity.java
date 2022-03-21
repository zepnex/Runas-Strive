package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public abstract class Entity {
    private int hp;
    private int focusPoints;
    private List<Card> abilitys;

    public void dealDamage(int amount) {
        hp -= amount;
    }

    public void heal(int amount) {
        hp = Math.min(hp + amount, getMaxHp());
    }



    protected abstract int getMaxHp();
}
