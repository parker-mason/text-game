package main;

import util.MyFrame;
import input.GetKey;

public class GameWindow extends MyFrame {
    protected GetKey getKey;

    public GameWindow() {
        getKey = new GetKey();
        this.getKey = getKey;
    }
}