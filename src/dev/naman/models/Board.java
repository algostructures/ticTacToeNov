package dev.naman.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public int getRows(){
        return board.size();
    }

    public int getCols(){
        return board.get(0).size();
    }

    public Cell getCell(int row, int col) {
        return board.get(row).get(col);
    }

    Board(int rows, int columns) {
        board = new ArrayList<>();
        for (int i = 0; i < rows; ++i) {
            board.add(new ArrayList<>());
            for (int j = 0; j < columns; ++j) {
                board.get(i).add(new Cell());
            }
        }
    }

    public void printBoard() {
        for (List<Cell> cells : board) {
            for (Cell cell : cells) {
                System.out.printf("%c ", cell.symbol == null ? ' ' : cell.symbol.getSymbol());
            }
        }
        System.out.print("\n");
    }
}


// wrapper classes
// I will create a deep copy of the class
// In Java it is impossible to create a deep copy


// In java everything is p[ass by value
// int a = 10;
// add(a) add(10)
// Cell a = new Cell() // value in a is not the object but it is the address of the object. If address a was 200
// doSomething(a) {
//   a.x = 10;
// }
