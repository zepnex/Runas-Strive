package edu.kit.informatik.controller.commands.resources;

/**
 * This class represents the messages inside the game.
 */
public enum Messages {
    /**
     * The message printed if an entity takes damage.
     */
    DAMAGE_TEMPLATE("%s takes %d %s damage\n"),
    /**
     * The message printed when a entity uses an ability.
     */
    TURN_TEMPLATE("%s uses %s\n"),
    /**
     * The message printed if an entity uses focus.
     */
    FOCUS_TEMPLATE("%s gains %d focus\n"),
    /**
     * The message printed when the player upgrades its dice.
     */
    UPGRADE_DICE_TEMPLATE("Runa upgrades her die to a d%d\n"),
    /**
     * The message printed when the player gains new cards.
     */
    CARD_RECEPTION_TEMPLATE("Runa gets %s\n"),
    /**
     * The message printed when the player heals.
     */
    HEALING_TEMPLATE("Runa gains %d health\n"),
    /**
     * The message printed when an entity dies.
     */
    DEATH_TEMPLATE("%s dies\n"),
    /**
     * The message printed when Runa wins.
     */
    WON_TEMPLATE("Runa won!"),
    /**
     * The message printed when Runa enters a room.
     */
    INTRO_TEMPLATE("Runa enters Stage %d of Level %d\n"),
    /**
     * The message printed to divide status from rest
     * also used to indicate the start of a new combat round
     */
    DIVIDER("----------------------------------------"),
    /**
     * The message printed to show status of Runa
     */
    RUNA_STATUS_TEMPLATE("Runa (%d/%d HP, %d/%d FP)\n"),
    /**
     * The message printed to divide between player and monster
     */
    VS_TEMPLATE("vs."),
    /**
     * The message printed to show the status of the monsters
     */
    MONSTER_STATUS_TEMPLATE("%s (%d HP, %d FP): attempts %s next\n");

    private final String content;

    /**
     * The constructor of the Dialog enum.
     *
     * @param content the content of the dialog
     */
    Messages(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
