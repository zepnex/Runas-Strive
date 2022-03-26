package edu.kit.informatik.model.abilities.player_abilities.physical;

import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Swing extends OffensiveCard {
    private static final String CARD_NAME = "Swing";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;

    public Swing(int n) {

        super(n);
    }

    //TODO: Bricht irgendwie Fokus
    @Override
    public int getDamage(int n, int w) {
        return 5 * n + w;
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
