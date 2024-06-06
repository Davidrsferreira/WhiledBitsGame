package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public abstract class LoopPadController extends PadsController {

    protected LoopPadController(Controller parent) {
        super(parent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        view.switchPad(keyboardEvent.getKey());

        if (sounds.get(keyboardEvent.getKey()).isOpen()) {
            sounds.get(keyboardEvent.getKey()).stop();
            return;
        }

        sounds.get(keyboardEvent.getKey()).setLoop();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /* none */
    }
}
