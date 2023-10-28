package main;


public class GameWindow
{
    private int playerY, playerX;
    private String key;
    private char[][] frame;
    private int[][] borderIndex;

    public GameWindow()
    {
        this.playerX = playerX;
        this.playerY = playerY;
        this.key = key;
        this.frame = frame;
        this.borderIndex = borderIndex;
    }

    public void makeFrame(int row, int col)
    {
        // initialize frame, borderIndex, and index
        this.frame = new char[row][col];
        this.borderIndex = new int[(row) * 2 + (col - 2) * 2][2];
        int index = 0;

        // iterate through this.frame
        for (int i = 0; i <= this.frame.length - 1; i++)
        {
            // assigns top outer index values
            this.borderIndex[index][1] = i;
            this.borderIndex[index][0] = 0;
            index++;
        }
        for (int i = 0; i <= (this.frame.length - 1); i++)
        {
            for (int j = 0; j <= (this.frame[i].length - 1); j++)
            {
                // check for outer frame index values
                for (int k = 0; k == 0 || k == (this.frame[i].length - 1); k += (this.frame[i].length - 1))
                {
                    if (j + (this.frame[i].length - 1) <= (this.frame.length - 1))
                    {
                        switch (i)
                        {
                            case 0 : 
                                break;
                            case 4 :
                                break;
                            default: 
                                if (k == 0 && i != 0)
                                {
                                    // assign side outer index values
                                    this.borderIndex[index][1] = k;
                                    this.borderIndex[index][0] = i;
                                    index++;
                                }
                                else if (k == 4 && i != 0)
                                {
                                    // assign side outer index values
                                    this.borderIndex[index][1] = k;
                                    this.borderIndex[index][0] = i;
                                    index++;
                                }
                                break;
                        }
                    }
                }
            }
        }
        // iterates through this.frame
        for (int i = 0; i <= (this.frame.length - 1); i++)
        {
            // assigns bottom outer index values
            this.borderIndex[index][1] = i;
            this.borderIndex[index][0] = 4;
            index++;
        }
        int index1 = 0, index2 = 0;
        int counter = 0;
    
        // iterates through this.borderIndex
        for (int i = 0; i < this.borderIndex.length; i++)
        {
            for (int j = 0; j < this.borderIndex[i].length; j++)
            {
                int num = this.borderIndex[i][j];
                
                // getting border indecies for this.frame
                if (j == 0)
                {
                    index1 = num;
                }
                else if (j == 1)
                {
                    index2 = num;
                }
                else
                {
                    System.out.println("Index Error");
                }
    
                // assign frame border chars to '#'
                if (counter == 0)
                {
                    counter++;
                }
                else if (counter == 1)
                {
                    this.frame[index1][index2] = '#';
                }
                else
                {
                    
                    System.out.println("Assignment Error");
                }
            }
        }

        // iterates through this.frame
        for (int i = 0; i < this.frame.length; i++)
        {
            for (int j = 0; j < this.frame[i].length; j++)
            {
                // assigns player cordinate values
                this.playerX = (row - 1) / 2;
                this.playerY = (col - 1) / 2;

                // assigns this.frame middle char (player) to '@'
                if (i == playerX && j == playerY)
                {
                    this.frame[i][j] = '@';
                }
                else if (this.frame[i][j] != '#')
                {
                    this.frame[i][j] = ' ';
                }
            }
        }
    }
    
    public void paintFrame(int col, int row)
    {
        // make frame
        this.makeFrame(col, row);
        
        // clear Screen
        this.cls();

        // print frame
        for (int i = 0; i < this.frame.length; i++)
        {
            for (int j = 0; j < this.frame[i].length; j++)
            {
                System.out.print(this.frame[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void cls()
    {
        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}