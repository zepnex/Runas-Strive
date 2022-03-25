package edu.kit.informatik.model.abilities;

public enum CardClass {
    MAGICAL("mag."),
    PHYSICAL("phy."),
    NONE("");

    private final String shortCut;

    CardClass(String shortCut) {
        this.shortCut = shortCut;
    }

    public String getShortCut() {
        return shortCut;
    }
}
