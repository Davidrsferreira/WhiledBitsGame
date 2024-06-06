package org.academiadecodigo.whiledlings.whiledbits;

import org.academiadecodigo.whiledlings.whiledbits.controller.MenuController;
import org.academiadecodigo.whiledlings.whiledbits.view.GfxGamePad;
import org.academiadecodigo.whiledlings.whiledbits.menu.MenuHandler;
import org.academiadecodigo.whiledlings.whiledbits.controller.Pads;
import org.academiadecodigo.whiledlings.whiledbits.controller.PadsNotes;
import org.academiadecodigo.whiledlings.whiledbits.controller.PadsSample;
import org.academiadecodigo.whiledlings.whiledbits.sound.SoundsGroup;


public class Game {

    private final MenuController controller = new MenuController();

    private boolean inMenu = true;
    private MenuHandler menuHandler;
    private SoundsGroup selectedGroup;
    private Pads selectedPadGroup;
    private GfxGamePad gfxGamePad;
    private PadsSample drums;
    private PadsNotes samples;
    private PadsNotes notes;
    private PadsNotes mcs;
    private Player player;
    public static final int soundLoop = 100;
    public static final String resourcesPathImages = "./resources/images/";
    public static final String menuPathImages = resourcesPathImages + "menu/";

    public void start() {
        controller.start();
    }

    public void startPad() {

        inMenu = false;
        gfxGamePad = new GfxGamePad();
        gfxGamePad.drawPad();

        drums = new PadsSample(SoundsGroup.DRUMS, gfxGamePad);
        samples = new PadsNotes(SoundsGroup.SAMPLES, gfxGamePad);
        notes = new PadsNotes(SoundsGroup.NOTES, gfxGamePad);
        //mcs = new PadsNotes(SoundsGroup.MCS, gfxGamePad);

        selectGroup(SoundsGroup.DRUMS);

        player = new Player(drums, samples, notes, mcs, this);
        player.init();

    }

    public void selectGroup(SoundsGroup soundsGroup) {

        selectedGroup = soundsGroup;

        switch (selectedGroup) {
            case DRUMS:
                selectedPadGroup = drums;
                gfxGamePad.selectDrumGroup();
                redrawPadsGroupGfx(drums);
                break;
            case SAMPLES:
                selectedPadGroup = samples;
                gfxGamePad.selectSampleGroup();
                redrawPadsGroupGfx(samples);
                break;
            case NOTES:
                selectedPadGroup = notes;
                gfxGamePad.selectNotesGroup();
                redrawPadsGroupGfx(notes);
                break;
        }
    }

    public Pads getSelectedPadGroup() {
        return selectedPadGroup;
    }

    private void redrawPadsGroupGfx(Pads pad) {

        for (int i=0; i<10; i++) {
            if (pad.activePad() != null) {
                if (pad.activePad()[i]) {
                    gfxGamePad.selectPad(i);
                    continue;
                }
                gfxGamePad.unselectPad(i);
            }
        }
    }

    public void setInMenu(){
        inMenu = true;
    }
}
