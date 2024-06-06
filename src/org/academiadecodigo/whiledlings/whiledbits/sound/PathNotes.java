package org.academiadecodigo.whiledlings.whiledbits.sound;

public enum PathNotes {
    PAD_E(SoundsGroup.NOTES.getPath() + "note1.wav"),
    PAD_R(SoundsGroup.NOTES.getPath() + "note2.wav"),
    PAD_T(SoundsGroup.NOTES.getPath() + "note3.wav"),
    PAD_Y(SoundsGroup.NOTES.getPath() + "note4.wav"),
    PAD_U(SoundsGroup.NOTES.getPath() + "note5.wav"),
    PAD_D(SoundsGroup.NOTES.getPath() + "note6.wav"),
    PAD_F(SoundsGroup.NOTES.getPath() + "note7.wav"),
    PAD_G(SoundsGroup.NOTES.getPath() + "note8.wav"),
    PAD_H(SoundsGroup.NOTES.getPath() + "note9.wav"),
    PAD_J(SoundsGroup.NOTES.getPath() + "note10.wav");

    private final String path;

    PathNotes(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
