package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

/**
 * This class represents a Fire card.
 *
 * @author unyrg
 * @version 1.0
 */
public class Fire extends OffensiveCard {
    private static final String CARD_NAME = "Fire";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;

    /**
     * Constructor for the Fire class.
     *
     * @param n the ability level of the card
     */
    public Fire(int n) {
        super(n);

    }

    @Override
    public int getDamage(int f) {
        return (2 * this.getAbilityLevel() + 5) * f;
    }

    @Override
    public boolean isEffectiveOn(MonsterType monsterType) {
        return monsterType.equals(MonsterType.ICE);
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
