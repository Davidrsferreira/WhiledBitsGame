package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.whiledlings.whiledbits.controller.Pad;

import java.util.HashMap;
import java.util.Map;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.whiledlings.whiledbits.view.Pads.*;

public class PadsView implements BasicView {

    private final Map<Integer, Pad> pads;

    public PadsView() {
        pads = new HashMap<>();
        initComponents();
    }

    @Override
    public void draw() {
        pads.forEach((key, pad) -> {
            pad.draw();
        });
    }

    @Override
    public void hide() {
        pads.forEach((key, pad) -> pad.hide());
    }

    private void initComponents() {
        final double END_LINE_1 = 360;
        pads.put(KEY_E, createPad(80, END_LINE_1, YELLOW));
        pads.put(KEY_R, createPad(350, END_LINE_1, BLUE));
        pads.put(KEY_T, createPad(620, END_LINE_1, PINK));
        pads.put(KEY_Y, createPad(890, END_LINE_1, YELLOW));
        pads.put(KEY_U, createPad(1160, END_LINE_1, BLUE));

        final double END_LINE_2 = 620;
        pads.put(KEY_D, createPad(80, END_LINE_2, YELLOW));
        pads.put(KEY_F, createPad(350, END_LINE_2, BLUE));
        pads.put(KEY_G, createPad(620, END_LINE_2, PINK));
        pads.put(KEY_H, createPad(890, END_LINE_2, YELLOW));
        pads.put(KEY_J, createPad(1160, END_LINE_2, BLUE));
    }

    private Pad createPad(double start, double end, Pads pad) {
        return new Pad(start, end, pad);
    }

    public void switchPad(int option) {
        pads.get(option).switchPad();
    }
}
