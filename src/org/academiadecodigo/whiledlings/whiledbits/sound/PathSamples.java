package org.academiadecodigo.whiledlings.whiledbits.sound;

public enum PathSamples {
    PAD_E(SoundsGroup.SAMPLES.getPath() + "batata.wav"),
    PAD_R(SoundsGroup.SAMPLES.getPath() + "PAD_R.wav"),
    PAD_T(SoundsGroup.SAMPLES.getPath() + "PAD_T.wav"),
    PAD_Y(SoundsGroup.SAMPLES.getPath() + "PAD_Y.wav"),
    PAD_U(SoundsGroup.SAMPLES.getPath() + "PAD_U.wav"),
    PAD_D(SoundsGroup.SAMPLES.getPath() + "PAD_D.wav"),
    PAD_F(SoundsGroup.SAMPLES.getPath() + "PAD_F.wav"),
    PAD_G(SoundsGroup.SAMPLES.getPath() + "PAD_G.wav"),
    PAD_H(SoundsGroup.SAMPLES.getPath() + "PAD_H.wav"),
    PAD_J(SoundsGroup.SAMPLES.getPath() + "PAD_J.wav");

    private final String path;

    PathSamples(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
