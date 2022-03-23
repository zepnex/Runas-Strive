package edu.kit.informatik.model.abilities.player_abilities.physical;

import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Swing extends OffensiveCard {
    private static final String CARD_NAME = "Swing";
    private static final CardType TYPE = CardType.OFFENSIVE;

    public Swing(int n) {

        super(n);
    }

    //TODO: Bricht irgendwie Fokus
    @Override
    public int getDamage(int n, int w) {
        return 5 * n + w;
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
