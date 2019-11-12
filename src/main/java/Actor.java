package main.java;

import java.util.ArrayList;

public class Actor {
    private String name;
    private ArrayList<Card> cards;

    public Actor(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public void drawCard(CardDeck deck) {
        this.cards.add(deck.drawCard());
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getScore();
        }
        return score;
    }

    public String createCardListString() {
        StringBuilder cardsList = new StringBuilder("");
        for (Card c: this.cards) {
            cardsList.append(c.getSuit());
            cardsList.append(c.getFaceForOutput());
            cardsList.append(", ");
        }
        return cardsList.substring(0, cardsList.length() - 2);
    }

    public String getName() {
        return this.name;
    }
}
