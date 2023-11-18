package main;

import util.MyFrame;

public class GameWindow extends MyFrame {
    private int counter = 0;

    public GameWindow() {

    }

    public void exist() {
        if (counter == 0) {
            this.play();
        }
        while (this.running()) {
            if (counter == 0) {
                this.getDimensions();
                counter++;
            }
            this.paintFrame();
            this.getKey();
            this.playerMovement();
        }
    }
}
