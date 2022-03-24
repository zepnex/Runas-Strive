package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Pierce extends OffensiveCard {
    private static final String CARD_NAME = "Pierce";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    public Pierce(int n) {

        super(n);
    }

    @Override
    public int getDamage(int n, int w) {
        return (7 * n + w) + (w > 5 ? 7 * n : 0);
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }


    @Override
    public CardClass getCardClass() {
        return CARD_CLASS;
    }
}
