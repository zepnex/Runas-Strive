package edu.kit.informatik.model.abilities;

public enum CardType {
    /**
     *
     */
    OFFENSIVE("O"),
    /**
     *
     */
    DEFENSIVE("D"),
    /**
     *
     */
    NONE("N");

    private String type;

    private CardType(String type) {
        this.type = type;
    }

}
