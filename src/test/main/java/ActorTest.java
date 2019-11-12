package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void drawCard() {
        CardDeck deck = new CardDeck();
        Actor actor = new Actor("");
        Card card = deck.getCards().get(0);
        actor.drawCard(deck);
        assertEquals(card, actor.getCards().get(0));
    }

    @Test
    void getScore() {
        CardDeck deck = new CardDeck();
        Actor actor = new Actor("");
        actor.drawCard(deck);
        actor.drawCard(deck);
        assertEquals(actor.getScore(), 13);
    }

    @Test
    void createCardListString() {
        CardDeck deck = new CardDeck();
        Actor actor = new Actor("");
        actor.drawCard(deck);
        actor.drawCard(deck);
        assertEquals(actor.createCardListString(), "DA, D2");
    }

    @Test
    void getName() {
        Actor actor = new Actor("s");
        assertEquals(actor.getName(), "s");
    }
}