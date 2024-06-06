package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_RELEASED;

public abstract class OneTouchPadController extends PadsController {

    protected OneTouchPadController(Controller parent) {
        super(parent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (sounds.get(keyboardEvent.getKey()).isOpen()) {
            return;
        }

        view.switchPad(keyboardEvent.getKey());
        sounds.get(keyboardEvent.getKey()).play();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        view.switchPad(keyboardEvent.getKey());
        sounds.get(keyboardEvent.getKey()).stop();
    }

    @Override
    protected void addKeyListeners() {
        addKeyboardListener(KEY_E, KEY_PRESSED);
        addKeyboardListener(KEY_R, KEY_PRESSED);
        addKeyboardListener(KEY_T, KEY_PRESSED);
        addKeyboardListener(KEY_Y, KEY_PRESSED);
        addKeyboardListener(KEY_U, KEY_PRESSED);
        addKeyboardListener(KEY_D, KEY_PRESSED);
        addKeyboardListener(KEY_F, KEY_PRESSED);
        addKeyboardListener(KEY_G, KEY_PRESSED);
        addKeyboardListener(KEY_H, KEY_PRESSED);
        addKeyboardListener(KEY_J, KEY_PRESSED);

        addKeyboardListener(KEY_E, KEY_RELEASED);
        addKeyboardListener(KEY_R, KEY_RELEASED);
        addKeyboardListener(KEY_T, KEY_RELEASED);
        addKeyboardListener(KEY_Y, KEY_RELEASED);
        addKeyboardListener(KEY_U, KEY_RELEASED);
        addKeyboardListener(KEY_D, KEY_RELEASED);
        addKeyboardListener(KEY_F, KEY_RELEASED);
        addKeyboardListener(KEY_G, KEY_RELEASED);
        addKeyboardListener(KEY_H, KEY_RELEASED);
        addKeyboardListener(KEY_J, KEY_RELEASED);
    }
}
