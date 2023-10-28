package main;

public class Game
{
    private GameWindow gameWindow;
    
    public Game()
    {
        gameWindow = new GameWindow();
        while (true)
        {
            gameWindow.paintFrame(5, 5);
        }
    }
}