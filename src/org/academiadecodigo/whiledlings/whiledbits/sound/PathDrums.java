package org.academiadecodigo.whiledlings.whiledbits.sound;

public enum PathDrums {
    PAD_E(SoundsGroup.DRUMS.getPath() + "beats/beat1.wav"),
    PAD_R(SoundsGroup.DRUMS.getPath() + "beats/beat2.wav"),
    PAD_T(SoundsGroup.DRUMS.getPath() + "beats/beat3.wav"),
    PAD_Y(SoundsGroup.DRUMS.getPath() + "beats/beat4.wav"),
    PAD_U(SoundsGroup.DRUMS.getPath() + "beats/beat5.wav"),
    PAD_D(SoundsGroup.DRUMS.getPath() + "beats/beat6.wav"),
    PAD_F(SoundsGroup.DRUMS.getPath() + "beats/beat7.wav"),
    PAD_G(SoundsGroup.DRUMS.getPath() + "beats/beat8.wav"),
    PAD_H(SoundsGroup.DRUMS.getPath() + "beats/beat9.wav"),
    PAD_J(SoundsGroup.DRUMS.getPath() + "beats/beat10.wav");

    private final String path;

    PathDrums(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
