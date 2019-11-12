package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card(Card.Suits.S, Card.Values.ACE);
        assertEquals(card.getSuit(), Card.Suits.S);
    }

    @Test
    void getFaceForOutput() {
        Card card = new Card(Card.Suits.S, Card.Values.ACE);
        assertEquals(card.getFaceForOutput(), "A");
    }

    @Test
    void getScore() {
        Card card = new Card(Card.Suits.S, Card.Values.ACE);
        assertEquals(card.getScore(), 11);
    }
}