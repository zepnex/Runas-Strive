package edu.kit.informatik.model.abilities;

public abstract class DefensiveCard extends Card {


    public DefensiveCard(int n) {
        super(n);
    }

    protected abstract int getDefense(int n);


}
