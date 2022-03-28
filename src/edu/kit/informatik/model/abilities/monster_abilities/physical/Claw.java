package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents a Claw card.
 *
 * @author unyrg
 * @version 1.0
 */
public class Claw extends OffensiveCard {
    private static final String CARD_NAME = "Claw";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;
    private static final int COST = 0;

    /**
     * The constructor of the Claw class.
     *
     * @param n the ability level of the card
     */
    public Claw(int n) {
        super(n);

    }

    @Override
    public int getDamage(int w) {
        return 6 * this.getAbilityLevel();
    }

    @Override
    public boolean isEffectiveOn(MonsterType monsterType) {
        return false;
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }

    @Override
    public CardClass getCardClass() {
        return CARD_CLASS;
    }

    @Override
    public boolean breaksFocus() {
        return true;
    }
}
