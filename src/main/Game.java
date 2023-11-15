package main;

public class Game {
    private GameWindow gameWindow;

    public Game(int col, int row) {
        boolean running = true;
        gameWindow = new GameWindow();
        while (running) {
            this.gameWindow.paintFrame(col, row);
            this.gameWindow.setKey();
            switch (this.gameWindow.getKey()) {
                case "q":
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
}