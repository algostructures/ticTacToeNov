package dev.naman.models;

import dev.naman.exceptions.DuplicateSymbolException;
import dev.naman.exceptions.InvalidPlayersQuanityException;
import dev.naman.strategies.winning.IWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Board board;
    private List<IWinningStrategy> winningStrategies = new ArrayList<>();
    private int currentPlayerIndex = 0;

    public List<Player> getPlayers() {
        return players;
    }

    private void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void run() {
        int totalTurns = board.getRows() * board.getCols();
        int turns = 0;

        F: while(turns < totalTurns) {
            printBoard();
            Player currentPlayer = getCurrentPlayer();
            System.out.println("Player "+currentPlayer.symbol+"'s turn");
            currentPlayer.makeMove(board);
            for (IWinningStrategy winningStrategy: winningStrategies) {
                Player winner = winningStrategy.checkWinner(board, players);
                if(winner != null) {
                    printBoard();
                    System.out.println("winner is"+ winner);
                    break F;
                }
            }
            updateCurrentPlayer();
            turns++;
        }
    }

    private void updateCurrentPlayer() {
        if (currentPlayerIndex < players.size()-1) {
            currentPlayerIndex++;
        } else {
            currentPlayerIndex = 0;
        }
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }


    private void setBoard(Board board) {
        this.board = board;
    }

    private void setWinningStrategies(List<IWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;
        private int rows;
        private int columns;

        Builder() {
            this.game = new Game();
        }

        public Builder addPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Builder addWinningStrategy(IWinningStrategy strategy) {
            game.winningStrategies.add(strategy);
            return this;
        }

        public Builder setRows(int rows) {
            this.rows = rows;
            return this;
        }

        public Builder setColumns(int columns) {
            this.columns = columns;
            return this;
        }

        public Game build() {
            if (game.getPlayers().size() < 2) {
                throw new InvalidPlayersQuanityException();
            }
            Set<Character> symbols = new HashSet<>();

            for (Player player: game.getPlayers()) {
                if (symbols.contains(player.symbol.getSymbol())) {
                    throw new DuplicateSymbolException();
                }
            }

            Board board = new Board(rows, columns);

            game.setBoard(board);
            return game;
        }
    }
}

// if you are implementing for extension,
// prefer lists
// today you are lallowing only 1 strategy
// 5 strategies
// Strategy1: all symbols of same type in 1 row
// Strategy 2: all symbols of same type in diagonal
// Strategy 3: all corners covered by same symbol
// 2^n