package edu.kit.informatik.model.abilities.monster_abilities.magical;

import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Lightning extends OffensiveCard {
    private static final String CARD_NAME = "Lightning";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Lightning(int n) {
        super(n);
    }


    @Override
    public int getDamage(int n, int w) {
        return 14 * n + 2;
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
