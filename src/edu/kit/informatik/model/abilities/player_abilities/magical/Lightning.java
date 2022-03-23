package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Lightning extends OffensiveCard {
    private static final String CARD_NAME = "Lightning";
    private static final CardType TYPE = CardType.OFFENSIVE;
    private static final int COST = 1;

    public Lightning(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int f) {
        return (2 * n + 5) * f + 2;
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
