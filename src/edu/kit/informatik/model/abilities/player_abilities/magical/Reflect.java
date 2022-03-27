package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

public class Reflect extends DefensiveCard {
    private static final String CARD_NAME = "Reflect";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 0;

    public Reflect(int n) {
        super(n);
    }

    @Override
    public int getDefense() {
        return 10 * this.getAbilityLevel();
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
