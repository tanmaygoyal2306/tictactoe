package com.tw.tictactoe;

import java.util.Optional;

public class GameRunner {

    private Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    public Optional<Game.Player> playGame(){

        return Optional.empty();
    }
}
