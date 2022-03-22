package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;

import java.util.List;

public class Player extends Entity {
    private static final int MAX_HP = 50;
    private final PlayerClass characterClass;
    private List<Card> cards;
    private int abilityLevel;
    private Card currentAttackCard;

    public Player(PlayerClass characterClass) {
        this.characterClass = characterClass;
        this.cards = cards;
        this.abilityLevel = 1;

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
        return currentAttackCard;
    }

    public void setCurrentAttackCard(Card currentAttackCard) {
        this.currentAttackCard = currentAttackCard;
    }
}
