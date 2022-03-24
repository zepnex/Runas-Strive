package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class Player extends Entity {
    private static final int MAX_HP = 50;
    private static final int FOCUS_POINTS = 1;
    private final CharacterClass characterClass;
    private List<Card> cards;
    private int abilityLevel;
    private Card currentCard;

    public Player(CharacterClass characterClass) {
        super(FOCUS_POINTS);
        this.characterClass = characterClass;
        this.abilityLevel = 1;
        this.cards = CharacterClass.getCards(characterClass, this);
    }

    public String getName() {
        return this.characterClass.name();
    }

    public int getAbilityLevel() {
        return abilityLevel;
    }

    public void setAbilityLevel(int abilityLevel) {
        this.abilityLevel = abilityLevel;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int getMaxHp() {
        return MAX_HP;
    }

    public Card getCurrentAttackCard() {
        return currentCard;
    }

    public void setCurrentAttackCard(Card currentAttackCard) {
        this.currentCard = currentAttackCard;
    }
}
