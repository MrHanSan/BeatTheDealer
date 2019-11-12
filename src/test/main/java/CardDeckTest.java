package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void drawCard() {
        CardDeck deck = new CardDeck();
        Card card = new Card(Card.Suits.D, Card.Values.ACE);
        assertNotEquals(deck.drawCard(), card);
    }
}