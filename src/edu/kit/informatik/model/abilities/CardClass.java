package edu.kit.informatik.model.abilities;

/**
 * This enum represents the different classes of cards.
 *
 * @author unyrg
 * @version 1.0
 */
public enum CardClass {
    /**
     * Defines a card as magical.
     */
    MAGICAL("mag."),
    /**
     * Defines a card as physical.
     */
    PHYSICAL("phy."),
    /**
     * Defines a card as neutral.
     */
    NONE("");

    private final String shortCut;

    /**
     * This constructor creates a new CardClass.
     *
     * @param shortCut the shortCut of the CardClass
     */
    CardClass(String shortCut) {
        this.shortCut = shortCut;
    }

    /**
     * This method returns the shortCut of the CardClass.
     *
     * @return the shortCut of the CardClass
     */
    public String getShortCut() {
        return shortCut;
    }
}
