package edu.kit.informatik.model.enteties;

import edu.kit.informatik.model.abilities.Card;

/**
 * This class represents an Entity.
 *
 * @author unyrg
 * @version 1.0
 */
public abstract class Entity {
    private int hp;
    private int focusPoints;
    private boolean isFocused;
    private Entity currentTarget;
    private Card currentCard = null;
    private int maxFocusPoint;

    /**
     * The constructor of the Entity class.
     *
     * @param focusPoints the amount of focus points the entity has
     */
    public Entity(int focusPoints) {
        hp = getMaxHp();
        this.focusPoints = focusPoints;
        isFocused = false;
    }

    /**
     * This methode check if a entity is dead.
     *
     * @return true if the entity is dead, false if not
     */
    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * This methode is used to deal damage to the entity.
     *
     * @param amount the amount of damage
     */
    public void dealDamage(int amount) {

        hp -= Math.max(0, amount);
    }

    /**
     * This methode heals the entity.
     *
     * @param amount the amount of heal
     * @return the amount the entity of healed
     */
    public int heal(int amount) {
        int temp = hp;
        hp = Math.min(hp + amount, getMaxHp());
        return hp - temp;
    }

    /**
     * This methode returns the current amount of focus points.
     *
     * @return the amount of focus points
     */
    public int getFocusPoints() {
        return focusPoints;
    }

    /**
     * This methode decreases the focus points of the entity.
     *
     * @param factor the amount to decrease
     */
    public void decreaseFocusPoints(int factor) {
        this.focusPoints -= factor;
        if (this.isPlayer() && this.focusPoints == 0) {
            focusPoints++;
        }
    }

    /**
     * This methode increases the focus points of the entity.
     *
     * @param factor the amount to increase
     * @return the amount of focus points the entity increased
     */
    public int increaseFocusPoints(int factor) {
        int free = getMaxFocusPoint() - this.focusPoints;
        if (free >= factor) {
            this.focusPoints += factor;
        } else {
            this.focusPoints = this.getMaxFocusPoint();
        }
        return Math.min(free, factor);
    }

    /**
     * This methode set the focus points of the entity.
     *
     * @param focusPoints the amount of focus points
     */
    public void setFocusPoints(int focusPoints) {
        this.focusPoints = focusPoints;
    }


    /**
     * This methode returns the current amount of hp.
     *
     * @return the amount of hp
     */
    public int getCurrentHp() {
        return hp;
    }

    /**
     * This methode toggles if the entity is focused.
     */
    public void toggleFocus() {
        isFocused = !isFocused;
    }

    /**
     * This methode checks if the entity is focused.
     *
     * @return true if the entity is focused, false if not
     */
    public boolean isFocused() {
        return isFocused;
    }

    /**
     * This methode gets the maximum amount of focus points.
     *
     * @return the maximum amount of focus points
     */
    public int getMaxFocusPoint() {
        return maxFocusPoint;
    }

    /**
     * This methode sets the maximum amount of focus points.
     *
     * @param maxFocusPoint the maximum amount of focus points
     */
    public void setMaxFocusPoint(int maxFocusPoint) {
        this.maxFocusPoint = maxFocusPoint;
    }

    /**
     * This methode returns the current target of the entity.
     *
     * @return the current target
     */
    public Entity getCurrentTarget() {
        return currentTarget;
    }

    /**
     * This methode sets the current target of the entity.
     *
     * @param currentTarget the current target
     */
    public void setCurrentTarget(Entity currentTarget) {
        this.currentTarget = currentTarget;
    }

    /**
     * This methode returns the current card of the entity.
     *
     * @return the current card
     */
    public Card getCurrentCard() {
        return currentCard;
    }

    /**
     * This methode sets the current card of the entity.
     *
     * @param currentCard the current card
     */
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    /**
     * This methode checks if the entity is a player.
     *
     * @return true if the entity is a player, false if not
     */
    public boolean isPlayer() {
        return false;
    }

    /**
     * This methode returns the name of the entity.
     *
     * @return the name of the entity
     */
    public abstract String getName();

    /**
     * This methode returns the maximum amount of hp.
     *
     * @return the maximum amount of hp
     */
    public abstract int getMaxHp();

}
