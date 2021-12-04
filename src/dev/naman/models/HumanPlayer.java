package dev.naman.models;

import java.util.Scanner;

public class HumanPlayer extends Player {
    User user;

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Enter Row And Col, Stupid Human");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        board.getCell(row, col).setSymbol(new Symbol(this.getSymbol().getSymbol()));
    }

    public static class Builder {
        private HumanPlayer humanPlayer;

        Builder() {
            this.humanPlayer = new HumanPlayer();
        }

        public Builder setUser(User user) {
            this.humanPlayer.user = user;
            return this;
        }

        public Builder setSymbol(char symbol) {
            this.humanPlayer.symbol = new Symbol(symbol);
            return this;
        }

        public HumanPlayer build() {
            return this.humanPlayer;
        }
    }
}
