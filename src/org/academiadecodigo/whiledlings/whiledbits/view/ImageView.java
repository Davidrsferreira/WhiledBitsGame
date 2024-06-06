package org.academiadecodigo.whiledlings.whiledbits.view;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.whiledbits.utils.PictureUtil;

public class ImageView implements BasicView {

    private final Picture img;

    public ImageView(String path) {
        img = PictureUtil.create(0, 0, path);
    }

    @Override
    public void draw() {
        img.draw();
    }

    @Override
    public void hide() { img.delete(); }
}
