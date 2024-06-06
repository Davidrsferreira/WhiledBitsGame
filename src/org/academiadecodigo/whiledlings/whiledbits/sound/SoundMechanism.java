package org.academiadecodigo.whiledlings.whiledbits.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SoundMechanism {

    private Clip clip;
    private boolean isOpen = false;

    public SoundMechanism(String path) {
        initClip(path);
    }

    public static SoundMechanism create(String path) {
        return new SoundMechanism(path);
    }

    public void play() {
        clip.start();
        isOpen = true;
    }

    public void stop() {
        clip.setFramePosition(0);
        clip.stop();
        isOpen = false;
    }

    public void setLoop(int times) {
        clip.loop(times);
        isOpen = true;
    }

    private void initClip(String path) {

        URL soundURL = SoundMechanism.class.getResource(path); //if loading from jar
        AudioInputStream inputStream;

        try {

            if (soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intellij
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}
