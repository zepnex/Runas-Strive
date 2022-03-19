package edu.kit.informatik.model.abilities;

public abstract class Card {
    private int abilityLevel;

    public Card(int n) {
        this.abilityLevel = n;

    }

    public abstract String getName();

    public int getAbilityLevel() {
        return abilityLevel;
    }

}
