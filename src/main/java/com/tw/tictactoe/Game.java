package com.tw.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;

public class Game {
    private Player currentPlayer;
    private GameState state;
    private Grid grid;


    private final List<List<Position>> winningPositions = new ArrayList<List<Position>>();

    public boolean isInProgress() {
        return state == GameState.INPROGRESS;
    }

    enum Player {
        PLAYER_X('X'){
            @Override
            public Player nextPlayer() {
                return PLAYER_O;
            }
        },
        PLAYER_O('O'){
            @Override
            public Player nextPlayer() {
                return PLAYER_X;
            }
        };

        private char playerCharacter;

        Player(char character) {
            playerCharacter = character;
        }

        public char getPlayerCharacter() {
            return playerCharacter;
        }

        public abstract Player nextPlayer();
    }

    public Game() {
        grid = new Grid();
        state = GameState.NEW;
        currentPlayer = Player.PLAYER_X;
        populateWinningPositions();
    }

    private void populateWinningPositions() {
        winningPositions.add(new GridChunk().add(0,0).add(0, 1).add(0, 2).extractChunk());
        winningPositions.add(new GridChunk().add(1,0).add(1, 1).add(1, 2).extractChunk());
        winningPositions.add(new GridChunk().add(2,0).add(2, 1).add(2, 2).extractChunk());

        winningPositions.add(new GridChunk().add(0,0).add(1, 0).add(2, 0).extractChunk());
        winningPositions.add(new GridChunk().add(0,1).add(1, 1).add(2, 1).extractChunk());
        winningPositions.add(new GridChunk().add(0,2).add(1, 2).add(2, 2).extractChunk());

        winningPositions.add(new GridChunk().add(0,0).add(1, 1).add(2, 2).extractChunk());
        winningPositions.add(new GridChunk().add(0,2).add(1, 1).add(2, 0).extractChunk());
    }

    public GameState getState() {
        return state;
    }


    public Optional<Player> runIteration(Position position) {
        if (state == GameState.NEW) {
            state = GameState.INPROGRESS;
        }

        grid.setCharAt(position, currentPlayer.getPlayerCharacter());

        if(checkForWinner()) {
            state = GameState.WON;
            return of(currentPlayer);
        }

        currentPlayer = currentPlayer.nextPlayer();

        return Optional.empty();
    }

    private boolean checkForWinner() {
        return winningPositions.stream().filter(listOfPostions -> grid.getCharAt(listOfPostions.get(1)) != Grid.DEFAULT_CHAR &&
            grid.getCharAt(listOfPostions.get(0)) == grid.getCharAt(listOfPostions.get(1)) &&
            grid.getCharAt(listOfPostions.get(2)) == grid.getCharAt(listOfPostions.get(1))
        ).peek(e -> System.out.println(e)).findAny().isPresent();
    }
}
