package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Ice extends OffensiveCard {
    private static final String CARD_NAME = "Ice";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Ice(int n) {
        super(n);

    }

    @Override
    protected int getDamage(int n, int w) {
        return 10 * n + 2;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }
}
