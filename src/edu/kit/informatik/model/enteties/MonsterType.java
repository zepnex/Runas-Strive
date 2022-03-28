package edu.kit.informatik.model.enteties;

/**
 * Enum for the different types of monsters.
 *
 * @author unyrg
 * @version 1.0
 */
public enum MonsterType {
    /**
     * Defines the type of a monster as water.
     */
    WATER("W"),
    /**
     * Defines the type of a monster as ice.
     */
    ICE("I"),
    /**
     * Defines the type of a monster as lightning.
     */
    LIGHTNING("L"),
    /**
     * Defines the type of a monster as Fire.
     */
    FIRE("F"),
    /**
     * Defines the type of a monster as neutral.
     */
    NORMAL("N");

    private String type;

    /**
     * Constructor for the MonsterType enum.
     *
     * @param type the type of the monster.
     */
    MonsterType(String type) {
        this.type = type;
    }
}
