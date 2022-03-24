package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;

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
    public CardClass getCardClass() {
        return CARD_CLASS;
    }


}
