package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Smash extends OffensiveCard {
    private static final String CARD_NAME = "Smash";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Smash(int n) {
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
    protected CardType getCardType() {
        return TYPE;
    }
}
