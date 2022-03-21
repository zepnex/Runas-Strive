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

public enum PlayerClass {
    WARRIOR(1),
    MAGE(2),
    PALADIN(3);

    private int charClass;

    PlayerClass(int charClass) {
        this.charClass = charClass;
    }


    public static PlayerClass getCharacter(int number) {
        for (PlayerClass character : PlayerClass.values()) {
            if (character.charClass == number) return character;
        }
        throw new IllegalStateException("Error: not reachable");
    }

    public static List<Card> getCards(PlayerClass playerClass, Player player) {
        switch (playerClass) {
            case MAGE:
                return new ArrayList<Card>(
                    List.of(new Focus(player.getAbilityLevel()), new Water(player.getAbilityLevel())));
            case WARRIOR:
                return new ArrayList<Card>(
                    List.of(new Thrust(player.getAbilityLevel()), new Parry(player.getAbilityLevel())));
            case PALADIN:
                return new ArrayList<Card>(
                    List.of(new Slash(player.getAbilityLevel()), new Reflect(player.getAbilityLevel())));
        }
        throw new IllegalStateException("yeah idk, somehow u broke the game");
    }
}
