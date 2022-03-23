package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardType TYPE = CardType.OFFENSIVE;
    private static final int COST = 1;

    public Water(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int f) {
        return (2 * n + 4) * f;
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
