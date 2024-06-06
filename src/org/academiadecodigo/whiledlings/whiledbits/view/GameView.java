package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.whiledbits.utils.PictureUtil;

import java.util.HashMap;
import java.util.Map;

import static org.academiadecodigo.whiledlings.whiledbits.Game.resourcesPathImages;
import static org.academiadecodigo.whiledlings.whiledbits.utils.PictureUtil.create;
import static org.academiadecodigo.whiledlings.whiledbits.view.GamePadsOption.*;

public class GameView implements BasicView {

    private static final String PATH = resourcesPathImages + "buttons/functional/";
    private final Rectangle view;
    private final Picture neon;
    private final Picture logo;
    private final Map<GamePadsOption, Picture> darkButtons = new HashMap<>();
    private final Map<GamePadsOption, Picture> brightButtons = new HashMap<>();

    public GameView() {
        view = new Rectangle(0,0,1440,900);
        view.setColor(Color.BLACK);
        neon = PictureUtil.create(0, 0, resourcesPathImages + "backGroundNeon_1.png");
        logo = PictureUtil.create(80, 80, resourcesPathImages + "logo.png");
        initComponents();
    }


    public void initComponents() {
        final int END_SIZE = 130;
        darkButtons.put(DRUMS, create(660, END_SIZE, PATH + "drum.png"));
        darkButtons.put(NOTES, create(930, END_SIZE, PATH + "notes.png"));
        //darkButtons.put(SAMPLES, create(1200, END_SIZE, PATH + "sample.png"));
        brightButtons.put(DRUMS, create(660, END_SIZE, PATH + "drumGlow.png"));
        brightButtons.put(NOTES, create(930, END_SIZE, PATH + "notesGlow.png"));
        //brightButtons.put(SAMPLES, create(1200, END_SIZE, PATH + "sampleGlow.png"));
    }

    @Override
    public void draw() {
        view.fill();
        neon.draw();
        logo.draw();
        darkButtons.forEach((key, button) -> button.draw());
        brightButtons.get(DRUMS).draw();
    }

    @Override
    public void hide() {
        view.delete();
        neon.delete();
        logo.delete();
        deleteDarkButtons();
        deleteBrightButtons();
    }

    public void selectPad(GamePadsOption option) {
        deleteBrightButtons();
        brightButtons.get(option).draw();
    }

    private void deleteBrightButtons() {
        brightButtons.forEach((key, value) -> value.delete());
    }

    private void deleteDarkButtons() {
        darkButtons.forEach((key, value) -> value.delete());
    }
}
