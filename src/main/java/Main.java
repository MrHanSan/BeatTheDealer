package main.java;

public class Main {
    public static void main(String[] args) {
        /**
         * Entry point for program. Checks for more than one command line arg. initiates the game, and runs the main game logic.
         */
        if (args.length > 1) {
            System.out.println("This game takes one file as argument, or no argument");
            System.out.println("Please only give one argument");
            return;
        }
        Game game = new Game(args);
        game.playGame();
    }
}
