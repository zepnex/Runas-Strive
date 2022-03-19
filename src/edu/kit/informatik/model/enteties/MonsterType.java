package edu.kit.informatik.model.enteties;

public enum MonsterType {
    /**
     *
     */
    WATER("W"),
    /**
     *
     */
    ICE("I"),
    /**
     *
     */
    LIGHTNING("L"),
    /**
     *
     */
    FIRE("F"),
    /**
     *
     */
    NORMAL("N");

    private String type;

    private MonsterType(String type) {
        this.type = type;
    }
}
