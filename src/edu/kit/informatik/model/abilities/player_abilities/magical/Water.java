package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents a Water card.
 *
 * @author unyrg
 * @version 1.0
 */
public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;

    /**
     * Constructor for the Water class.
     *
     * @param n the ability level of the card
     */
    public Water(int n) {
        super(n);

    }

    @Override
    public int getDamage(int f) {
        return (2 * this.getAbilityLevel() + 4) * f;
    }

    @Override
    public boolean isEffectiveOn(MonsterType monsterType) {
        return monsterType.equals(MonsterType.LIGHTNING);
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
