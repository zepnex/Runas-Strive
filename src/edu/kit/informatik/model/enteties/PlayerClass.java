package edu.kit.informatik.model.enteties;


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
}
