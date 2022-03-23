package edu.kit.informatik.model.abilities;

public abstract class DefensiveCard extends Card {


    public DefensiveCard(int n) {
        super(n);
    }

    public abstract int getDefense(int n);


}
