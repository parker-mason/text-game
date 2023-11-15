package main;

import input.GetKey;

public class Main {
    public static void main(String[] args) {
        GetKey getKey = new GetKey();
        String key = "";
        int col;
        int row;

        System.out.print("Enter the game dimensions: ");
        col = Integer.parseInt(getKey.getKey(key));
        row = col;

        new Game(col, row);
    }
}