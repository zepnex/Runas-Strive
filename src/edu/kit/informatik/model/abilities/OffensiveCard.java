package edu.kit.informatik.model.abilities;

public abstract class OffensiveCard extends Card {
    private int cost;


    public OffensiveCard(int n) {
        super(n);
        this.cost = n;
    }

    protected abstract int getDamage(int n, int w);


    public int getCost() {
        return cost;
    }
}
