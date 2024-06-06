package org.academiadecodigo.whiledlings.whiledbits.utils;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PictureUtil {

    public static Picture create(double start, double end, String path) {
        return new Picture(start, end, path);
    }

}
