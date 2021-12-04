package dev.naman.strategies.winning;

import dev.naman.models.Board;
import dev.naman.models.Player;
import dev.naman.models.Symbol;

import java.util.List;

public class ColumnWinningStrategy implements IWinningStrategy {
    @Override
    public Player checkWinner(Board board, List<Player> players) {
        for (int i = 0; i < board.getCols(); i++) {
            if(board.getCell(0, i).getSymbol() == null) return null;
            boolean winner = true;
            char symbol = board.getCell(0, i).getSymbol().getSymbol();
            for (int j = 1; j < board.getRows(); j++) {
                if(board.getCell(j,i).getSymbol() == null || symbol != board.getCell(j,i).getSymbol().getSymbol()) {
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
