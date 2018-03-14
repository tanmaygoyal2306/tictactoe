package com.tw.tictactoe;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void gameShouldBeInNewStateOnCreation() {
        Game game = new Game();
        assertEquals(GameState.NEW, game.getState());
    }

    @Test
    public void gameShouldBeInProgressStateAfterFirstIteration() {
        Game game = new Game();
        game.runIteration(new Position(0, 0));
        assertEquals(GameState.INPROGRESS, game.getState());
    }

    /*@Test(expected = PositionAlreadySetException.class)
    public void gameShouldThrowExceptionWhenUpdatingAlreadySetPosition() {
        Game game = new Game();
        game.runIteration(0, 0);
        assertEquals(GameState.PLAYER_O, game.getState());
    }*/

    @Test
    public void shouldReturnWinningPlayerForWinningPositions() {
        Game game = new Game();

        game.runIteration(new Position(0, 0));
        game.runIteration(new Position(1, 0));
        game.runIteration(new Position(0, 1));
        game.runIteration(new Position(2, 0));
        Optional<Game.Player> winner = game.runIteration(new Position(0, 2));

        assertTrue(winner.isPresent());
        assertFalse(game.isInProgress());
    }

    @Test
    public void shouldReturnEmptyOptionalIfGameIsNotWon() {
        Game game = new Game();

        game.runIteration(new Position(0, 0));
        game.runIteration(new Position(1, 0));
        game.runIteration(new Position(1, 1));
        game.runIteration(new Position(2, 0));
        Optional<Game.Player> winner = game.runIteration(new Position(0, 2));

        assertFalse(winner.isPresent());
        assertTrue(game.isInProgress());
    }
}