package org.academiadecodigo.whiledlings.whiledbits.pads;

import org.academiadecodigo.whiledlings.whiledbits.gfx.GfxGamePad;
import org.academiadecodigo.whiledlings.whiledbits.sound.SoundMechanism;
import org.academiadecodigo.whiledlings.whiledbits.sound.SoundsGroup;

public class PadsNotes extends Pads{

    private SoundsGroup soundsGroup;
    private SoundMechanism[] sounds;
    private boolean[] playing;
    GfxGamePad gfxGamePad;

    public PadsNotes(SoundsGroup soundsGroup, GfxGamePad gfxGamePad) {

        this.soundsGroup = soundsGroup;
        this.gfxGamePad = gfxGamePad;
        playing = new boolean[9];
        sounds = new SoundMechanism[9];

        for (int i = 0; i < sounds.length; i++){
            sounds[i] = new SoundMechanism(PathNotes.values()[i].getPath());
            playing[i] = false;
        }

    }


    @Override
    public void padPressed(int pad) {

        if (!playing[pad]){
            sounds[pad].play(true);
            playing[pad] = true;
            gfxGamePad.selectPad(pad);
        }
    }

    @Override
    public void padReleased(int pad) {

        sounds[pad].stop();
        playing[pad] = false;
        gfxGamePad.unselectPad(pad);

    }

    @Override
    public boolean[] activePad() {
        return playing;
    }
}
