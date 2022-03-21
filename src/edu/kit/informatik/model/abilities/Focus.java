package edu.kit.informatik.model.abilities;

public class Focus extends Card {
    private static final String CARD_NAME = "Focus";
    private static final CardType TYPE = CardType.NONE;

    public Focus(int n) {
        super(n);
    }

    @Override
    public String getName() {
        return CARD_NAME;
    }
}
