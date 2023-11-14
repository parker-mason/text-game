package main;

public class Game
{
    private GameWindow gameWindow;
    
    public Game()
    {
        boolean running = true;
        gameWindow = new GameWindow();
        while (running)
        {
            this.gameWindow.paintFrame(5, 5);
            this.gameWindow.setKey();
            switch (this.gameWindow.getKey())
            {
                case "q" :
                    running = false;
                    break;
                default :
                    break;
            }
        }
    }
}