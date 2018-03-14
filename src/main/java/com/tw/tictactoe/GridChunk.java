package com.tw.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GridChunk {
    private List<Position> positions;

    public GridChunk(){
        positions = new ArrayList<Position>();
    }

    public GridChunk add(int row, int column){
        positions.add(new Position(row, column));
        return this;
    }

    public List<Position> extractChunk(){
        return Collections.unmodifiableList(positions);
    }
}
