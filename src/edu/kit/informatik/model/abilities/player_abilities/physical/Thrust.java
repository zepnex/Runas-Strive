package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Thrust extends OffensiveCard {
    private static final String CARD_NAME = "Thrust";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Thrust(int n) {
        super(n);
    }

    @Override
    protected int getDamage(int n, int w) {
        return (6 * n + w) + (w > 5 ? 5 * n : 0);
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }

}
