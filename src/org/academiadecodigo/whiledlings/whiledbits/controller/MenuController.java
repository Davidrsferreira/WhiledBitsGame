package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.whiledlings.whiledbits.sound.SoundMechanism;
import org.academiadecodigo.whiledlings.whiledbits.view.MenuOption;
import org.academiadecodigo.whiledlings.whiledbits.view.MenuView;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;
import static org.academiadecodigo.whiledlings.whiledbits.Game.resourcesPathImages;

public class MenuController extends Controller {

    private final MenuView view;
    private final SoundMechanism menuSound = SoundMechanism.create("/resources/sounds/introSong.wav");
    private final GameController gameController;
    private final ChildController instructionsController;
    private final ChildController kcsController;

    public MenuController() {
        super();
        view = new MenuView();
        gameController = new GameController(this);
        instructionsController = new ImageController(this, resourcesPathImages + "menu/menuWallInst.png");
        kcsController = new ImageController(this, resourcesPathImages + "menu/menuWallKcs.png");
    }

    @Override
    protected void addKeyListeners() {
        addKeyboardListener(KeyboardEvent.KEY_LEFT, KEY_PRESSED);
        addKeyboardListener(KeyboardEvent.KEY_RIGHT, KEY_PRESSED);
        addKeyboardListener(KeyboardEvent.KEY_SPACE, KEY_PRESSED);
        addKeyboardListener(KeyboardEvent.KEY_Q, KEY_PRESSED);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                view.changeOption(-1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                view.changeOption(1);
                break;
            case KeyboardEvent.KEY_SPACE:
                selectOption();
                break;
            case KeyboardEvent.KEY_Q:
                stop();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /* none */
    }

    @Override
    public void start() {
        addKeyListeners();

        if (!menuSound.isOpen()) {
            menuSound.setLoop();
            menuSound.play();
        }

        view.draw();
    }

    @Override
    protected void stop() {
        System.exit(0);
    }

    private void selectOption() {
        removeKeyListeners();

        switch (view.getCurrentOption()) {
            case MenuOption.PLAY:
                menuSound.stop();
                view.hide();
                gameController.start();
                break;
            case MenuOption.INSTRUCTIONS:
                view.hide();
                instructionsController.start();
                break;
            case MenuOption.KCS:
                view.hide();
                kcsController.start();
                break;
        }
    }
}
