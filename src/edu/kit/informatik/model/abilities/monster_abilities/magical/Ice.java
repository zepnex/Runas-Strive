package edu.kit.informatik.model.abilities.monster_abilities.magical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Ice extends OffensiveCard {
    private static final String CARD_NAME = "Ice";
    private static final CardClass CARD_CLASS = CardClass.MAGICAL;
    private static final int COST = 1;


    public Ice(int n) {
        super(n);
        setCost(COST);
    }

    @Override
    public int getDamage(int n, int w) {
        return 10 * n + 2;
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
}
