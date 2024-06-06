package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.whiledlings.whiledbits.sound.SoundMechanism;
import org.academiadecodigo.whiledlings.whiledbits.view.PadsView;

import java.util.HashMap;
import java.util.Map;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_J;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public abstract class PadsController extends ChildController {

    protected final PadsView view;
    protected final Map<Integer, SoundMechanism> sounds = new HashMap<>();

    public PadsController(Controller parent) {
        super(parent);
        view = new PadsView();
        loadSounds();
    }

    @Override
    protected void start() {
        view.draw();
        addKeyListeners();
    }

    @Override
    protected void stop() {
        removeKeyListeners();
        view.hide();
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
    }

    protected abstract void loadSounds();
}
