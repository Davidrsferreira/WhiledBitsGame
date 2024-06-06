package org.academiadecodigo.whiledlings.whiledbits;

import org.academiadecodigo.whiledlings.whiledbits.controller.MenuController;


public class Game {

    private final MenuController controller = new MenuController();
    public static final String resourcesPathImages = "./resources/images/";
    public static final String menuPathImages = resourcesPathImages + "menu/";

    public void start() {
        controller.start();
    }
}
