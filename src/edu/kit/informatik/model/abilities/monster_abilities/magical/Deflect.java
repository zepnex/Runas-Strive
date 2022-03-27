package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

public class Deflect extends DefensiveCard {
    private static final String CARD_NAME = "Deflect";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;

    // TODO: naechsten angriff

    public Deflect(int n) {
        super(n);
    }

    @Override
    public int getDefense() {
        return 11 * this.getAbilityLevel() + 2;
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
