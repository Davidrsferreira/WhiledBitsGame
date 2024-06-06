package org.academiadecodigo.whiledlings.whiledbits.controller;

public abstract class ChildController extends Controller {

    protected final Controller parent;

    protected ChildController(Controller parent) {
        super();
        this.parent = parent;
    }
}
