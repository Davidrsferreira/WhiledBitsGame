package org.academiadecodigo.whiledlings.whiledbits.controller;

public abstract class Pads {

    public abstract void padPressed(int pad);

    public abstract void padReleased(int pad);

    public abstract boolean[] activePad();

    public abstract void stopAllSongs();

}
