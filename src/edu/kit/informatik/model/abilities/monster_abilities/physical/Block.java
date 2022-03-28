package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.DefensiveCard;

/**
 * This class represents a Block ability.
 *
 * @author unyrg
 * @version 1.0
 */
public class Block extends DefensiveCard {
    private static final String CARD_NAME = "Block";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    /**
     * The constructor of the Block class.
     *
     * @param n the ability level of the Block card
     */
    public Block(int n) {
        super(n);
    }

    @Override
    public int getDefense() {
        return 7 * this.getAbilityLevel();
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
