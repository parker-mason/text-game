package util;

import input.GetKey;

public class MyFrame {
    protected GetKey getKey = new GetKey();
    protected boolean running = true;
    protected char[][] frame;
    protected char playerChar = '@';
    protected char tempPlayerChar = ' ';
    protected int[][] borderIndex;
    protected int makeCounter = 0;
    protected int playerX;
    protected int playerY;
    protected String key = "null";

    public MyFrame() {
        this.frame = frame;
        this.playerChar = playerChar;
        this.borderIndex = borderIndex;
        this.playerX = playerX;
        this.playerY = playerY;
        this.key = key;
    }

    public void makeFrame(int col, int row) {

        // initialize variables
        this.frame = new char[row][col];
        this.borderIndex = new int[(row * 2) + ((col - 2) * 2)][2];
        int frameLength = this.frame.length;
        int index = 0;
        if (makeCounter == 0) {
            this.playerX = (row - 1) / 2;
            this.playerY = (col - 1) / 2;
            makeCounter++;
        }

        // iterate through this.frame
        for (int i = 0; i <= this.frame.length - 1; i++) {
            // assigns top outer index values
            this.borderIndex[index][1] = i;
            this.borderIndex[index][0] = 0;
            index++;
        }
        for (int i = 0; i <= (this.frame.length - 1); i++) {
            for (int j = 0; j <= (this.frame[i].length - 1); j++) {
                // check for outer frame index values
                for (int k = 0; k == 0 || k == (this.frame[i].length - 1); k += (this.frame[i].length - 1)) {
                    if (j + (this.frame[i].length - 1) <= (this.frame.length - 1)) {
                        if (i == 0) {

                        } else if (i == frameLength - 1) {

                        } else {
                            if (k == 0 && i != 0) {
                                // assign side outer index values
                                this.borderIndex[index][1] = k;
                                this.borderIndex[index][0] = i;
                                index++;
                            } else if (k == (frameLength - 1) && i != 0) {
                                // assign side outer index values
                                this.borderIndex[index][1] = k;
                                this.borderIndex[index][0] = i;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        // iterates through this.frame
        for (int i = 0; i <= (this.frame.length - 1); i++) {
            // assigns bottom outer index values
            this.borderIndex[index][1] = i;
            this.borderIndex[index][0] = frameLength - 1;
            index++;
        }
        int index1 = 0, index2 = 0;
        int counter = 0;

        // iterates through this.borderIndex
        for (int i = 0; i < this.borderIndex.length; i++) {
            for (int j = 0; j < this.borderIndex[i].length; j++) {
                int num = this.borderIndex[i][j];

                // getting border indecies for this.frame
                if (j == 0) {
                    index1 = num;
                } else if (j == 1) {
                    index2 = num;
                } else {
                    System.out.println("Index Error");
                }

                // assign frame border chars to '#'
                if (counter == 0) {
                    counter++;
                } else if (counter == 1) {
                    this.frame[index1][index2] = '#';
                } else {

                    System.out.println("Assignment Error");
                }
            }
        }

        // iterates through this.frame
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {

                // assigns this.frame middle char (player) to playerChar
                if (i == this.playerY && j == this.playerX) {
                    this.frame[i][j] = playerChar;
                } else if (this.frame[i][j] != '#') {
                    this.frame[i][j] = ' ';
                }
            }
        }
    }

    public void paintFrame(int col, int row) {
        // make frame
        this.makeFrame(col, row);

        // clear Screen
        this.cls();

        // print frame
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                System.out.print(this.frame[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void cls() {
        // clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void getKey() {
        String retrivedKey = this.getKey.getKey(this.key);
        this.key = retrivedKey;
    }

    public boolean running() {
        return this.running;
    }

    public boolean playerMovement() {
        switch (this.key) {
            case "q":
                this.running = false;
                break;
            case "w":
                this.moveUp();
                break;
            case "a":
                this.moveLeft();
                break;
            case "s":
                this.moveDown();
                break;
            case "d":
                this.moveRight();
                break;
            default:
                break;
        }
        return this.running;
    }

    public void moveUp() {
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (this.frame[i][j] == playerChar) {
                    if (this.frame[i - 1][j] != '#') {
                        this.playerY--;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (this.frame[i][j] == playerChar) {
                    if (this.frame[i][j - 1] != '#') {
                        this.playerX--;
                    }
                }
            }
        }
    }

    public void moveDown() {
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (this.frame[i][j] == playerChar) {
                    if (this.frame[i + 1][j] != '#') {
                        this.playerY++;
                    }
                }
            }
        }
    }

    public void moveRight() {
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (this.frame[i][j] == playerChar) {
                    if (this.frame[i][j + 1] != '#') {
                        this.playerX++;
                    }
                }
            }
        }
    }
}