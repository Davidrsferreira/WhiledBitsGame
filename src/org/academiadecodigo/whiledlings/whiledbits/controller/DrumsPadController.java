package org.academiadecodigo.whiledlings.whiledbits.controller;

import org.academiadecodigo.whiledlings.whiledbits.sound.SoundMechanism;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.whiledlings.whiledbits.sound.PathDrums.*;

public class DrumsPadController extends LoopPadController {

    protected DrumsPadController(Controller parent) {
        super(parent);
    }

    @Override
    protected void loadSounds() {
        sounds.put(KEY_E, SoundMechanism.create(PAD_E.getPath()));
        sounds.put(KEY_R, SoundMechanism.create(PAD_R.getPath()));
        sounds.put(KEY_T, SoundMechanism.create(PAD_T.getPath()));
        sounds.put(KEY_Y, SoundMechanism.create(PAD_Y.getPath()));
        sounds.put(KEY_U, SoundMechanism.create(PAD_U.getPath()));
        sounds.put(KEY_D, SoundMechanism.create(PAD_D.getPath()));
        sounds.put(KEY_F, SoundMechanism.create(PAD_F.getPath()));
        sounds.put(KEY_G, SoundMechanism.create(PAD_G.getPath()));
        sounds.put(KEY_H, SoundMechanism.create(PAD_H.getPath()));
        sounds.put(KEY_J, SoundMechanism.create(PAD_J.getPath()));
    }
}
