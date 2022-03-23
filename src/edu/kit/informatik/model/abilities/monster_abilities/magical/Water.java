package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Water(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int w) {
        return 8 * n + 2;
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
