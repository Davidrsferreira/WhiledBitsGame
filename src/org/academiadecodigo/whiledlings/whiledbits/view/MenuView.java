package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.whiledbits.Game;

import java.util.HashMap;
import java.util.Map;

import static org.academiadecodigo.whiledlings.whiledbits.utils.PictureUtil.create;
import static org.academiadecodigo.whiledlings.whiledbits.view.MenuOption.*;

public class MenuView implements BasicView {

    private final Picture menuBackground = new Picture(0, 0, Game.menuPathImages + "menuBackground.png");
    private final Map<MenuOption, Picture> darkButtons = new HashMap<>();
    private final Map<MenuOption, Picture> brightButtons = new HashMap<>();
    private MenuOption currentOption;

    public MenuView() {
        initComponents();
    }

    @Override
    public void draw() {
        menuBackground.draw();
        brightButtons.forEach((key, button) -> button.draw());
        darkButtons.get(INSTRUCTIONS).draw();
        currentOption = INSTRUCTIONS;
    }

    @Override
    public void hide() {
        menuBackground.delete();
        brightButtons.forEach((key, button) -> button.delete());
        darkButtons.forEach((key, button) -> button.delete());
    }

    public void changeOption(int direction) {
        int index = currentOption.ordinal() + direction;

        if (index < 0 || index >= MenuOption.values().length ) {
            return;
        }

        resetOptions();
        currentOption = MenuOption.values()[index];
        darkButtons.get(currentOption).draw();
    }

    public MenuOption getCurrentOption() {
        return currentOption;
    }

    private void initComponents() {
        final double PICTURE_SIZE = 595.6;
        darkButtons.put(PLAY, create(115.5, PICTURE_SIZE, PLAY.getDarkPath()));
        brightButtons.put(PLAY, create(115.5, PICTURE_SIZE, PLAY.getBrightPath()));
        darkButtons.put(INSTRUCTIONS, create(549.3, PICTURE_SIZE, INSTRUCTIONS.getDarkPath()));
        brightButtons.put(INSTRUCTIONS, create(549.3, PICTURE_SIZE, INSTRUCTIONS.getBrightPath()));
        darkButtons.put(KCS, create(977.5, PICTURE_SIZE, KCS.getDarkPath()));
        brightButtons.put(KCS, create(977.5, PICTURE_SIZE, KCS.getBrightPath()));
    }

    private void resetOptions() {
        darkButtons.forEach((key, value) -> { value.delete(); });
    }
}
