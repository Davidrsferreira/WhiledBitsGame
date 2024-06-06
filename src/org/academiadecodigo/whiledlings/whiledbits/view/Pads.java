package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.whiledlings.whiledbits.Game;

public enum Pads {
    YELLOW(Game.resourcesPathImages + "buttons/pads/padYellow"),
    BLUE(Game.resourcesPathImages + "buttons/pads/padBlue"),
    PINK(Game.resourcesPathImages + "buttons/pads/padPink");

    private final String darkPath;
    private final String brightPath;

    Pads(String path){
        this.darkPath = path + ".png";
        this.brightPath = path + "Glow.png";
    }

    public String getDarkPath() {
        return darkPath;
    }

    public String getBrightPath() {
        return brightPath;
    }
}
