package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.whiledlings.whiledbits.view.GameView;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;
import static org.academiadecodigo.whiledlings.whiledbits.view.GamePadsOption.*;

public class GameController extends ChildController {

    private final GameView view;
    private final LoopPadController drumsController;
    private final OneTouchPadController notesController;

    public GameController(Controller parent) {
        super(parent);
        this.view = new GameView();
        drumsController = new DrumsPadController(this);
        notesController = new NotesPadController(this);
    }

    @Override
    public void start() {
        view.draw();
        view.selectPad(DRUMS);
        addKeyListeners();
        drumsController.start();
    }

    @Override
    protected void stop() {
        removeKeyListeners();
        view.hide();
        parent.start();
    }

    @Override
    protected void addKeyListeners() {
        addKeyboardListener(KeyboardEvent.KEY_1, KEY_PRESSED);
        addKeyboardListener(KeyboardEvent.KEY_2, KEY_PRESSED);
        addKeyboardListener(KeyboardEvent.KEY_Q, KEY_PRESSED);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_1:
                view.selectPad(DRUMS);
                notesController.stop();
                drumsController.start();
                break;
            case KeyboardEvent.KEY_2:
                view.selectPad(NOTES);
                drumsController.stop();
                notesController.start();
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
}
