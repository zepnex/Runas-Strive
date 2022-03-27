package edu.kit.informatik.model.abilities.monster_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Smash extends OffensiveCard {
    private static final String CARD_NAME = "Smash";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;
    private static final int COST = 0;

    public Smash(int n) {
        super(n);
        setCost(COST);
    }

    @Override
    public int getDamage(int n, int w) {
        return 8 * n;
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
