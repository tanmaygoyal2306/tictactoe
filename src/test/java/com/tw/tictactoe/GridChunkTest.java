package com.tw.tictactoe;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GridChunkTest {

    @Test
    public void shouldBeAbleToAddPositions() {
        GridChunk chunk = new GridChunk();
        List<Position> positions = chunk.add(1,2)
                .add(2,2)
                .add(2,1).extractChunk();

        assertEquals(new Position(1, 2), positions.get(0));
        assertEquals(new Position(2, 2), positions.get(1));
        assertEquals(new Position(2, 1), positions.get(2));
    }

}