package dev.naman.models;

public abstract class Player {

    Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);
}
