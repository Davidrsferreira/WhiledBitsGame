package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_RELEASED;

public class Keyboard implements KeyListener {

    private final KeyboardHandler handler;
    private final List<KeyboardEvent> keyboardEventArrayList;

    public Keyboard(KeyboardHandler handler) {
        Canvas.getInstance().addKeyListener(this);
        this.handler = handler;
        this.keyboardEventArrayList = new ArrayList<>();
    }

    public void addEventListener(KeyboardEvent e) {
        keyboardEventArrayList.add(e);
    }

    public void clearEventListeners() {
        keyboardEventArrayList.clear();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (handler != null) {
            List<KeyboardEvent> events = getEvents();
            for (KeyboardEvent event : events) {
                if (validateKey(event, KEY_PRESSED, e)) {
                    handler.keyPressed(event);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (handler != null) {
            List<KeyboardEvent> events = getEvents();
            for (KeyboardEvent event : events) {
                if (validateKey(event, KEY_RELEASED, e)) {
                    handler.keyReleased(event);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    private ArrayList<KeyboardEvent> getEvents() {
        return new ArrayList<>(keyboardEventArrayList);
    }

    private boolean validateKey(KeyboardEvent event, KeyboardEventType type, KeyEvent e) {
        return event.getKeyboardEventType() == type && event.getKey() == e.getKeyCode();
    }
}
