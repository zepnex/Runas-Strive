package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;

public class Claw extends OffensiveCard {
    private static final String CARD_NAME = "Claw";
    private static final CardType TYPE = CardType.DEFENSIVE;

    public Claw(int n) {
        super(n);
    }
    //TODO: Bricht Focus von runa

    @Override
    protected int getDamage(int n, int w) {
        return 6 * n;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }
}
