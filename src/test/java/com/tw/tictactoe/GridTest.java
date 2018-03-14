package com.tw.tictactoe;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void shouldBePopulatedWithDefaultCharOnCreation() {
        Grid grid = new Grid();
        for (int i = 0; i < Grid.SIZE; i++) {
            for (int j = 0; j < Grid.SIZE; j++) {
                Assert.assertEquals(Grid.DEFAULT_CHAR, grid.getCharAt(new Position(i, j)));
            }
        }
    }

    @Test
    public void shouldUpdateDataAtSpecificPosition() {
        Grid grid = new Grid();
        Position position = new Position(0, 0);
        grid.setCharAt(position, 'X');
        assertEquals(grid.getCharAt(position), 'X');
    }

    @Test
    public void shouldReturnTrueForAlreadySetPosition() {
        Grid grid = new Grid();
        grid.setCharAt(new Position(0, 0),'X');
        assertTrue(grid.isPositionSet(new Position(0, 0)));

    }

    @Test
    public void shouldReturnFalseForNotSetPosition() {
        Grid grid = new Grid();
        grid.setCharAt(new Position(0, 0),'X');
        assertFalse(grid.isPositionSet(new Position(0, 1)));

    }
}