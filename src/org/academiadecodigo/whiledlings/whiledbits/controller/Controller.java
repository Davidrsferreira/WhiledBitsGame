package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public abstract class Controller implements KeyboardHandler {

    protected final Keyboard keyboard;

    protected Controller() {
        keyboard = new Keyboard(this);
    }

    protected abstract void start();
    protected abstract void stop();
    protected abstract void addKeyListeners();

    protected void removeKeyListeners() {
        keyboard.clearEventListeners();
    };

    protected void addKeyboardListener(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(type);
        event.setKey(key);
        keyboard.addEventListener(event);
    }
}
