package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

public class Reflect extends DefensiveCard {
    private static final String CARD_NAME = "Reflect";
    private static final CardType TYPE = CardType.NONE;
    private static final int COST = 0;

    public Reflect(int n) {
        super(n);
    }

    @Override
    public int getDefense(int n) {
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
