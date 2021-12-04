package dev.naman.strategies.winning;

import dev.naman.models.Board;
import dev.naman.models.Player;
import dev.naman.models.Symbol;

import java.util.List;

public class RowWinningStrategy implements IWinningStrategy {
    @Override
    public Player checkWinner(Board board, List<Player> players) {
        for (int i = 0; i < board.getRows(); i++) {
            if(board.getCell(i, 0).getSymbol() == null) return null;
            boolean winner = true;
            char symbol = board.getCell(i, 0).getSymbol().getSymbol();
            for (int j = 1; j < board.getCols(); j++) {
                if(board.getCell(i,j).getSymbol() == null || symbol != board.getCell(i,j).getSymbol().getSymbol()) {
                    winner = false;
                    break;
                }
            }
            if(winner) {
                for (Player player : players) {
                    if(player.getSymbol().getSymbol() == symbol)
                        return player;
                }
            }
        }
        return null;
    }
}
