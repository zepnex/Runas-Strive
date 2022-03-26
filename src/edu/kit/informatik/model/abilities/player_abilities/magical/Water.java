package edu.kit.informatik.model.abilities.player_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Water extends OffensiveCard {
    private static final String CARD_NAME = "Water";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;

    public Water(int n) {
        super(n);
        setCost(COST);
    }

    @Override
    public int getDamage(int n, int f) {
        return (2 * n + 4) * f;
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
