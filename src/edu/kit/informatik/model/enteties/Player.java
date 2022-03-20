package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class Player {
    private final PlayerClass characterClass;
    private List<Card> cards;
    private int abilityLevel;


    public Player(PlayerClass characterClass) {
        this.characterClass = characterClass;
        this.cards = cards;
        this.abilityLevel = 1;

    }

    public String getName() {
        return characterClass.name();
    }

    public int getAbilityLevel() {
        return abilityLevel;
    }

    public void setAbilityLevel(int abilityLevel) {
        this.abilityLevel = abilityLevel;
    }
}
