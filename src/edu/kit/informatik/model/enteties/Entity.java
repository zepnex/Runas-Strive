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
        isFocused = false;
    }

    public void dealDamage(int amount) {
        hp -= amount;
    }

    public int heal(int amount) {
        int temp = hp;
        hp = Math.min(hp + amount, getMaxHp());
        return hp - temp;
    }

    public int getFocusPoints() {
        return focusPoints;
    }

    public void decreaseFocusPoints(int factor) {
        this.focusPoints -= factor;
        if (this.isPlayer() && this.focusPoints == 0) {
            focusPoints++;
        }
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

    public int getMaxFocusPoint() {
        return maxFocusPoint;
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
