package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Bite extends OffensiveCard {
    private static final String CARD_NAME = "Bite";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    public Bite(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int w) {
        return 10 * n;
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
