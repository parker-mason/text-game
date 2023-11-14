package input;

import java.util.Scanner;
import util.MyKeyListener;

public class GetKey implements MyKeyListener
{
    Scanner scanner = new Scanner(System.in);

    public GetKey()
    {

    }

    @Override
    public String getKey(String key)
    {
        key = scanner.next();
        scanner.nextLine();
        return key;
    }
}