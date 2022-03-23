package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

public class Block extends DefensiveCard {
    private static final String CARD_NAME = "Block";
    private static final CardType TYPE = CardType.DEFENSIVE;

    public Block(int n) {
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
