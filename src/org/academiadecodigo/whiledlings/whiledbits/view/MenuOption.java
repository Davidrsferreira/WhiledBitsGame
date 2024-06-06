package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.whiledlings.whiledbits.Game;

public enum MenuOption {
    PLAY(Game.resourcesPathImages + "menu/menuPlay"),
    INSTRUCTIONS(Game.resourcesPathImages + "menu/menuInst"),
    KCS(Game.resourcesPathImages + "menu/menuKcs");

    private final String darkPath;
    private final String brightPath;

    MenuOption(String darkPath){
        this.darkPath = darkPath + ".png";
        this.brightPath = darkPath + "Glow.png";
    }

    public String getDarkPath() {
        return darkPath;
    }

    public String getBrightPath() {
        return brightPath;
    }

}
