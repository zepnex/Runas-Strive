package edu.kit.informatik.model.enteties;


import edu.kit.informatik.model.abilities.Card;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.player_abilities.magical.Reflect;
import edu.kit.informatik.model.abilities.player_abilities.magical.Water;
import edu.kit.informatik.model.abilities.player_abilities.physical.Parry;
import edu.kit.informatik.model.abilities.player_abilities.physical.Slash;
import edu.kit.informatik.model.abilities.player_abilities.physical.Thrust;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a character class.
 *
 * @author unyrg
 * @version 1.0
 */
public enum CharacterClass {
    /**
     * Defines the class of a player as a warrior.
     */
    WARRIOR(1),
    /**
     * Defines the class of a player as a mage.
     */
    MAGE(2),
    /**
     * Defines the class of a player as a paladin.
     */
    PALADIN(3);

    private final int charID;

    /**
     * The constructor of the enum.
     *
     * @param charID the id of the character class.
     */
    CharacterClass(int charID) {
        this.charID = charID;
    }

    /**
     * Returns the id of the character class.
     *
     * @return the id of the character class.
     */
    public int getCharID() {
        return charID;
    }

    /**
     * This methode returns the name of the character class.
     *
     * @param number the id of the character class.
     * @return the name of the character class.
     */
    public static CharacterClass getCharacter(int number) {
        for (CharacterClass character : CharacterClass.values()) {
            if (character.charID == number) return character;
        }
        throw new IllegalStateException("Error, not reachable");
    }

    /**
     * This method returns the list of starter abilities of the character class.
     *
     * @param playerClass the character class.
     * @param player      the player.
     * @return the list of starter abilities of the character class.
     */
    public static List<Card> getCards(CharacterClass playerClass, Player player) {
        List<Card> cards = new ArrayList<>();
        switch (playerClass) {
            case MAGE:
                cards = new ArrayList<>(
                        List.of(new Focus(player.getAbilityLevel()), new Water(player.getAbilityLevel())));
                break;
            case WARRIOR:
                cards = new ArrayList<>(
                        List.of(new Thrust(player.getAbilityLevel()), new Parry(player.getAbilityLevel())));
                break;
            case PALADIN:
                cards = new ArrayList<>(
                        List.of(new Slash(player.getAbilityLevel()), new Reflect(player.getAbilityLevel())));
                break;
            default:
                break;
        }
        return cards;
    }

}
