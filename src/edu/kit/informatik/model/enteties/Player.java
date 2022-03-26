package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class Player extends Entity {
    private static final int MAX_HP = 50;
    private static final int FOCUS_POINTS = 1;
    public static final String NAME = "Runa";
    private static final int MAX_DICE = 12;
    private final CharacterClass characterClass;
    public int dice;
    private List<Card> cards;
    private int abilityLevel;

    public Player(CharacterClass characterClass) {
        super(FOCUS_POINTS);
        this.characterClass = characterClass;
        setAbilityLevel(1);
        this.cards = CharacterClass.getCards(characterClass, this);
        this.dice = 4;
        setMaxFocusPoint(this.dice);
    }

    public String getName() {
        return NAME;
    }

    public int getAbilityLevel() {
        return abilityLevel;
    }

    public void setAbilityLevel(int abilityLevel) {
        this.abilityLevel = abilityLevel;
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }


    public int getDice() {
        return dice;
    }

    public void increaseDice(int getDice) {
        if (dice < MAX_DICE) {
            this.dice = getDice;
            setMaxFocusPoint(this.dice);
        }
    }


    @Override
    public boolean isPlayer() {
        return true;
    }

}
