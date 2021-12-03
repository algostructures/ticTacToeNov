package dev.naman.strategies.winning;

import dev.naman.models.Board;
import dev.naman.models.Player;
import dev.naman.models.Symbol;

import java.util.List;

public class DefaultWinningStrategy implements IWinningStrategy {
    @Override
    public Player checkWinner(Board board, List<Player> players) {
        boolean winner = true;
        for (int i = 0; i < board.getRows(); i++) {
            char symbol = board.getCell(i, 0).getSymbol().getSymbol();
            for (int j = 1; j < board.getCols(); j++) {
                if(symbol != board.getCell(i,j).getSymbol().getSymbol()) {
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
