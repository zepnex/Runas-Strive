package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class Player {
    private final PlayerClass characterClass;
    private List<Card> cards;


    public Player(PlayerClass characterClass) {
        this.characterClass = characterClass;
        this.cards = cards;

    }

    public String getName(){
        return characterClass.name();
    }


}
