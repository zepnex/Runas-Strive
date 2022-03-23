package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;


public class Fire extends OffensiveCard {
    private static final String CARD_NAME = "Fire";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Fire(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int w) {
        return 12 * n + 2;
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
