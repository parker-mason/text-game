package util;

import input.GetKey;

public class MyFrame {
    protected GetKey getKey = new GetKey();
    protected boolean running = false;
    protected boolean inventoryOpen = false;
    protected char[][] frame;
    protected char[][] inventory;
    protected char playerChar = '@';
    protected char tempPlayerChar = ' ';
    protected char item1 = ' ';
    protected char item2 = ' ';
    protected char item3 = ' ';
    protected int[][] borderIndex;
    protected int playerX;
    protected int playerY;
    protected int row, col;
    protected String key = "null";

    public MyFrame() {
        this.inventoryOpen = inventoryOpen;
        this.frame = frame;
        this.inventory = inventory;
        this.playerChar = playerChar;
        this.borderIndex = borderIndex;
        this.playerX = playerX;
        this.playerY = playerY;
        this.key = key;
        this.row = row;
        this.col = col;
    }

    public void makeFrame() {
        this.frame = new char[this.row][this.col];
        this.borderIndex = new int[row * col][2];
        this.playerX = (this.row - 1) / 2;
        this.playerY = (this.col - 1) / 2;

        int b1 = 0;
        int b2 = 0;
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (b2 == 0) {
                    this.borderIndex[b1][b2] = i;
                    this.borderIndex[b1][b2 + 1] = j;
                    b1++;
                } else {
                    b2 = 0;
                }
            }
        }
        for (int i = 0; i < this.borderIndex.length; i++) {
            for (int j = 0; j < this.borderIndex[i].length; j++) {
                if (j == 0 && this.borderIndex[i][j] == 0) {
                    this.frame[this.borderIndex[i][j]][this.borderIndex[i][j + 1]] = '#';
                } else if (j == 0 && this.borderIndex[i][j] == this.frame.length - 1) {
                    this.frame[this.borderIndex[i][j]][this.borderIndex[i][j + 1]] = '#';
                } else if (j == 0 && (this.borderIndex[i][j] != 0 || this.borderIndex[i][j] != this.frame.length - 1)) {
                    if (this.borderIndex[i][j + 1] == 0 || this.borderIndex[i][j + 1] == this.frame.length - 1) {
                        this.frame[this.borderIndex[i][j]][this.borderIndex[i][j + 1]] = '#';
                    }
                } else {
                    if (j == 0 && this.frame[this.borderIndex[i][j]][this.borderIndex[i][j + 1]] != '#'
                            && (this.borderIndex[i][j] != this.playerY || this.borderIndex[i][j + 1] != this.playerX)) {
                        this.frame[this.borderIndex[i][j]][this.borderIndex[i][j + 1]] = ' ';
                    } else if (j == 1 && this.frame[this.borderIndex[i][j - 1]][this.borderIndex[i][j]] != '#'
                            && (this.borderIndex[i][j - 1] != this.playerY || this.borderIndex[i][j] != this.playerX)) {
                        this.frame[this.borderIndex[i][j - 1]][this.borderIndex[i][j]] = ' ';
                    }
                    this.frame[this.playerY][this.playerX] = this.playerChar;
                }
            }
        }
    }

    public void paintFrame() {
        this.makeFrame();
        this.cls();
        if (this.inventoryOpen) {
            this.paintInventory();
        } else if (!this.inventoryOpen) {
            for (int i = 0; i < this.frame.length; i++) {
                for (int j = 0; j < this.frame[i].length; j++) {
                    System.out.print(this.frame[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Inventory ERROR");
        }
    }

    public void makeIventory() {
        this.inventory = new char[5][7];
        for (int i = 0; i < this.inventory.length - 1; i++) {
            for (int j = 0; j < this.inventory[i].length - 1; j++) {
                this.inventory[i][j] = 'I';
            }
        }
    }

    public void paintInventory() {
        this.makeIventory();
        for (int i = 0; i < this.inventory.length - 1; i++) {
            for (int j = 0; j < this.inventory[i].length - 1; j++) {
                System.out.print(this.inventory[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void toggleInventory() {
        this.inventoryOpen = !this.inventoryOpen;
    }

    public void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void getKey() {
        String retrivedKey = this.getKey.getKey(this.key);
        this.key = retrivedKey;
    }

    public void getDimensions() {
        System.out.print("Enter the game dimensions: ");
        this.col = Integer.parseInt(getKey.getKey(this.key));
        this.row = this.col;
    }

    public boolean running() {
        return this.running;
    }

    public void play() {
        this.running = true;
    }

    public boolean playerMovement() {
        switch (this.key) {
            case "q":
                this.running = false;
                break;
            case "w":
                if (this.inventoryOpen == true) {
                    break;
                } else {
                    this.moveUp();
                    break;
                }
            case "a":
                if (this.inventoryOpen == true) {
                    break;
                } else {
                    this.moveLeft();
                    break;
                }
            case "s":
                if (this.inventoryOpen == true) {
                    break;
                } else {
                    this.moveDown();
                    break;
                }
            case "d":
                if (this.inventoryOpen == true) {
                    break;
                } else {
                    this.moveRight();
                    break;
                }
            case "e":
                this.toggleInventory();
            default:
                break;
        }
        return this.running;
    }

    public void moveUp() {
        for (int i = 0; i < this.frame.length; i++) {
            for (int j = 0; j < this.frame[i].length; j++) {
                if (this.frame[i][j] == this.playerChar) {
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
                if (this.frame[i][j] == this.playerChar) {
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
                if (this.frame[i][j] == this.playerChar) {
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
                if (this.frame[i][j] == this.playerChar) {
                    if (this.frame[i][j + 1] != '#') {
                        this.playerX++;
                    }
                }
            }
        }
    }
}
