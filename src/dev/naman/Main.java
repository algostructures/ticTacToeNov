package dev.naman;

import dev.naman.controllers.GameController;
import dev.naman.factories.PlayerFactory;
import dev.naman.models.*;
import dev.naman.strategies.automove.RandomMoveStrategy;
import dev.naman.strategies.winning.ColumnWinningStrategy;
import dev.naman.strategies.winning.DefaultWinningStrategy;
import dev.naman.strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getBuilder()
                .addPlayer(
                        PlayerFactory.createHumanPlayer()
                        .setUser(new User())
                        .setSymbol('O')
                        .build()
                )
                .addPlayer(
                        PlayerFactory.createBot()
                                .setMoveStrategy(new RandomMoveStrategy())
                                .setSymbol('X')
                                .build()
                )
                .addWinningStrategy(new RowWinningStrategy())
                .addWinningStrategy(new ColumnWinningStrategy())
                .setRows(3)
                .setColumns(3)
                .build();
        GameController.run(game);
    }
}

// It returns an object of the subtype of a supercass

// Test Driven Development
// Write test cases first and after that write the code
// Test case ~~ client code
// Gojek
// Client willinteract with an api (methods)
// behind the scenes interact with the different entities/ services I have
// Board, Game, Player
// Where is this application going to be used
// - Web based applications: Some APIs
// Eg /game/create /game/move /game/quit => send request via postman
// race conditions: how will you handle race conditions

// - Command line applications
// - read inputs from the terminal and do similar actions
// - CreateGame pi p2
// - MakeMove 1,3 2,4
// Implement a [program that works in a good way -> test if you know how to
// distribute code in apckages
// bms, splitwise etc -> web based applications

// Restaurant
// Waiter -> Chef -> inmgredients from fridge -> AC / Normal
// Controller (Door to a massive system)
// Service (Chef)
// Model (Ingredients)
// Repositories (Fridge)

// before project building

// Splitwise etc

// client side app -> we don't want any persistent
// web based applications
// command line application: keep taking inputs and performa actions
// CreateGame p1 p2
// MakeMove 1,3 4,5
// Exit

// Client {
//   createGame();
//   makeMove(game, (1, 2), (4, 5))
// }

// where you have a separate servier (serving via REST apis)

// no straight path to implementation
// haphazard


// a builder for a player -> symbol
// a builder for a bot -> difficult strategy
// a builder for a human player -> user detal=ils