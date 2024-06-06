package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.whiledbits.view.Pads;

import static org.academiadecodigo.whiledlings.whiledbits.utils.PictureUtil.create;

public class Pad {

    private boolean isSelected = false;
    private final Picture active;
    private final Picture inactive;

    public Pad(double start, double end, Pads pad) {
        active = create(start, end, pad.getBrightPath());
        inactive = create(start, end, pad.getDarkPath());
    }

    public void switchPad() {
        if (isSelected) {
            active.delete();
        } else {
            active.draw();
        }

        isSelected = !isSelected;
    }

    public void hide() {
        active.delete();
        inactive.delete();
    }

    public void draw() {
        inactive.draw();

        if (isSelected) {
            active.draw();
        }
    }
}
