package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

/**
 * Reduces the physically damage of a monster in the next round
 */
public class Parry extends DefensiveCard {
    private static final String CARD_NAME = "Parry";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Parry(int n) {
        super(n);
    }

    @Override
    public int getDefense(int n) {
        return 7 * n;
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
