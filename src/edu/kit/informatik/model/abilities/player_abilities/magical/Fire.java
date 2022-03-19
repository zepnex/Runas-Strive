package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Fire extends OffensiveCard {
    private static final String CARD_NAME = "Fire";
    private static final CardType TYPE = CardType.OFFENSIVE;
    private static final int COST = 1;

    public Fire(int n) {
        super(n);
    }

    @Override
    protected int getDamage(int n, int f) {
        return (2 * n + 5) * f;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }
}
