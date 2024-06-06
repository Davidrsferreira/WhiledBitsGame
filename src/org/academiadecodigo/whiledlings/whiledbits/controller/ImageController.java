package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.whiledlings.whiledbits.view.ImageView;

public class ImageController extends ChildController {

    private final ImageView view;

    public ImageController(Controller parent, String path) {
        super(parent);
        view = new ImageView(path);
    }

    @Override
    public void start() {
        addKeyListeners();
        view.draw();
    }

    @Override
    public void stop() {
        removeKeyListeners();
        view.hide();
        parent.start();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (KeyboardEvent.KEY_Q == keyboardEvent.getKey()) {
            stop();
        }
    }

    @Override
    protected void addKeyListeners() {
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_Q);
        keyboard.addEventListener(event);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /* none */
    }
}
