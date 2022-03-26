package edu.kit.informatik.model.abilities.player_abilities.physical;


import edu.kit.informatik.model.abilities.CardClass;
import edu.kit.informatik.model.abilities.CardType;
import edu.kit.informatik.model.abilities.OffensiveCard;
import edu.kit.informatik.model.enteties.MonsterType;

public class Slash extends OffensiveCard {
    private static final String CARD_NAME = "Slash";
    private static final CardClass CARD_CLASS = CardClass.PHYSICAL;


    public Slash(int n) {
        super(n);
    }

    //TODO: Bricht irgendwie Focus
    @Override
    public int getDamage(int n, int w) {
        return 4 * n + w;
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
