package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

public class Deflect extends DefensiveCard {
    private static final String CARD_NAME = "Deflect";
    private static final CardType TYPE = CardType.DEFENSIVE;

    // TODO: naechsten angriff

    public Deflect(int n) {
        super(n);

    }

    @Override
    public int getDefense(int n) {
        return 11 * n + 2;
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
