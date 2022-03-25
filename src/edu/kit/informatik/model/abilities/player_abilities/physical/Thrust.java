package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Thrust extends OffensiveCard {
    private static final String CARD_NAME = "Thrust";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    public Thrust(int n) {
        super(n);
    }

    @Override
    public int getDamage(int n, int w) {
        return (6 * n + w) + (w > 5 ? 4 * n : 0);
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
