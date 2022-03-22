package edu.kit.informatik.model.enteties;

public abstract class Entity {
    private int hp;
    private int focusPoints;


    public Entity() {
        hp = getMaxHp();
        this.focusPoints = 1;

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

    public void increaseFocusPoints() {
        this.focusPoints += 1;
    }

    public int getCurrentHp() {
        return hp;
    }

    public abstract String getName();

    public abstract int getMaxHp();

}
