package main;

public class Game
{
    private GameWindow gameWindow;
    
    public Game()
    {
        gameWindow = new GameWindow();
        while (true)
        {
            gameWindow.myFrame.
            paintFrame(5, 5);
        }
    }
}