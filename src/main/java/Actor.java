package main.java;

import java.util.ArrayList;

/**
 * Class for dealer and player(s).
 */
public class Actor {

    private String name;
    private ArrayList<Card> cards;

    /**
     * Constructor for players and dealer. Gives takes a name and initiates an empty ArrayList for cards to be drawn into.
     * @param name Name of player/ dealer.
     */
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

    /**
     * Sums the value of the cards an actor has drawn.
     * @return int sum of value of drawn cards.
     */
    public int getScore() {
        int score = 0;
        for (Card card : this.cards) {
            score += card.getScore();
        }
        return score;
    }

    /**
     * Formats the list of drawn cards when displayed at the end of the game.
     * @return String Representation of an actors drawn cards.
     */
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
