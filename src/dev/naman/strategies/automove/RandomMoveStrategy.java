package dev.naman.strategies.automove;

import dev.naman.models.*;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements IAutomaticMoveStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        while(true) {
            int row = getRandomNumberInRange(0, board.getRows()-1);
            int col = getRandomNumberInRange(0, board.getCols()-1);
            if(board.getCell(row, col).getSymbol() == null) {
                board.getCell(row, col).setSymbol(new Symbol(player.getSymbol().getSymbol()));
                return new Move(row, col);
            }
        }
    }
    private int getRandomNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
