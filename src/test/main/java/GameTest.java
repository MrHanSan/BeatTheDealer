package main.java;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void playGame() {
        final ByteArrayOutputStream gameResult = new ByteArrayOutputStream();
        System.setOut(new PrintStream(gameResult));
        String[] file = new String[1];
        file[0] = "cards.txt";
        Game game = new Game(file);
        game.playGame();
        final String standardOutput = gameResult.toString();
        final String expectedResult = "sam\nsam: CA, H9\ndealer: D5, HQ, S8\n";
        assertEquals(standardOutput, expectedResult);
    }
}