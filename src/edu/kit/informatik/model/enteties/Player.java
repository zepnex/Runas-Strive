package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

/**
 * This class represents a player in the game.
 *
 * @author unyrg
 * @version 1.0
 */
public class Player extends Entity {
    private static final int MAX_HP = 50;
    private static final int FOCUS_POINTS = 1;
    private static final String NAME = "Runa";
    private static final int MAX_DICE = 12;
    private final CharacterClass characterClass;
    private final List<Card> cards;
    private int dice;
    private int abilityLevel;

    /**
     * Constructor for the Player class.
     *
     * @param characterClass the character class of the player
     */
    public Player(CharacterClass characterClass) {
        super(FOCUS_POINTS);
        this.characterClass = characterClass;
        setAbilityLevel(1);
        this.cards = CharacterClass.getCards(characterClass, this);
        this.dice = 4;
        setMaxFocusPoint(this.dice);
    }

    /**
     * This method returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return NAME;
    }

    /**
     * This method returns the ability level of the player.
     *
     * @return the ability level of the player
     */
    public int getAbilityLevel() {
        return abilityLevel;
    }

    /**
     * This method sets the ability level of the player.
     *
     * @param abilityLevel the ability level of the player
     */
    public void setAbilityLevel(int abilityLevel) {
        this.abilityLevel = abilityLevel;
    }

    /**
     * This method adds new cards to the players deck.
     *
     * @param cards the cards to add
     */
    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * This method returns the deck of the player.
     *
     * @return the deck of the player
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * This methode returns the current dice the player has.
     *
     * @return the current die the player has
     */
    public int getDice() {
        return dice;
    }

    /**
     * This methode upgrade the dice of the player.
     *
     * @param getDice the value of the upgrade to add
     */
    public void increaseDice(int getDice) {
        if (dice < MAX_DICE) {
            this.dice = getDice;
            setMaxFocusPoint(this.dice);
        }
    }

    /**
     * This method returns the max dice the player can have.
     *
     * @return the max dice the player can have
     */
    public int getMaxDice() {
        return MAX_DICE;
    }

    /**
     * This method returns the character class of the player.
     *
     * @return the character class of the player
     */
    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void decreaseFocusPoints(int factor) {
        setFocusPoints(Math.max(1, getFocusPoints() - 1));
    }
}
