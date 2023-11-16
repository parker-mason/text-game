package main;

public class Game {
    private GameWindow gameWindow;

    public Game(int col, int row) {
        gameWindow = new GameWindow();
        while (this.gameWindow.running()) {
            this.gameWindow.paintFrame(col, row);
            this.gameWindow.getKey();
            gameWindow.playerMovement();
        }
    }
}