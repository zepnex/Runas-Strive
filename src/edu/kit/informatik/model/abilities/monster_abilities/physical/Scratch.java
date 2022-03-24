package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Scratch extends OffensiveCard {
    private static final String CARD_NAME = "Scratch";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    public Scratch(int n) {
        super(n);
    }
    //TODO: Bricht Focus

    @Override
    public int getDamage(int n, int w) {
        return 5 * n;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }

    @Override
    public CardClass getCardClass() {
        return CARD_CLASS;
    }
}
