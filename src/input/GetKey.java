package input;

import java.util.Scanner;
import util.MyKeyListener;

import main.GameWindow;

public class GetKey implements MyKeyListener
{
    Scanner scanner = new Scanner(System.in);
    private GameWindow gameWindow;

    public GetKey(GameWindow gameWindow)
    {
        this.gameWindow = gameWindow;
    }

    @Override
    public void keyTyped()
    {
        String key = scanner.next();
        gameWindow.setKey(key);
        scanner.nextLine();
    }
}