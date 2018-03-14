package com.tw.tictactoe;

import java.util.Arrays;

public class Grid {

    public static final char DEFAULT_CHAR = 'P';
    private char[][] grid;
    public final static int SIZE = 3;

    public Grid() {
        this.grid = new char[SIZE][SIZE];
        for (int i = 0; i < Grid.SIZE; i++){
            for (int j = 0; j < Grid.SIZE; j++){
                grid[i][j] = DEFAULT_CHAR;
            }
        }
    }

    public char getCharAt(Position position) {
        return grid[position.getRow()][position.getColumn()];
    }


    public void setCharAt(Position position, char character) {
        grid[position.getRow()][position.getColumn()] = character;
    }


    public boolean isPositionSet(Position position) {
        return grid[position.getRow()][position.getColumn()]  != DEFAULT_CHAR;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Grid.SIZE; i++){
            for (int j = 0; j < Grid.SIZE; j++){
                builder.append(grid[i][j] + " ");
            }
            builder.append("\n");
        }
        builder.append("=============");
        return builder.toString();
    }
}
