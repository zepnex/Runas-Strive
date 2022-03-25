package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

public abstract class Entity {
    private int hp;
    private int focusPoints;
    private boolean isFocused;
    private Entity currentTarget;
    private Card currentCard = null;
    private int maxFocusPoint;


    public Entity(int focusPoints) {
        hp = getMaxHp();
        this.focusPoints = focusPoints;
    }

    public void dealDamage(int amount) {
        hp -= amount;
    }

    public void heal(int amount) {
        hp = Math.min(hp + amount, getMaxHp());
    }

    public int getFocusPoints() {
        return focusPoints;
    }

    public void decreaseFocusPoints(int factor) {
        this.focusPoints -= factor;
    }

    public void increaseFocusPoints() {
        if (this.focusPoints < maxFocusPoint)
            this.focusPoints += 1;
    }

    public int getCurrentHp() {
        return hp;
    }

    public void toggleFocus() {
        isFocused = !isFocused;
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setMaxFocusPoint(int maxFocusPoint) {
        this.maxFocusPoint = maxFocusPoint;
    }

    public Entity getCurrentTarget() {
        return currentTarget;
    }

    public void setCurrentTarget(Entity currentTarget) {
        this.currentTarget = currentTarget;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public boolean isPlayer() {
        return false;
    }

    public abstract String getName();

    public abstract int getMaxHp();

}
