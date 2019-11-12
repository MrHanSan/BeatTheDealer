package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private ArrayList<Card> cards;

    /**
     * Constructor for a full deck of cards, used when no card list is given.
     */
    public CardDeck() {
        this.cards = new ArrayList<Card>();
        for (Card.Suits s: Card.Suits.values()) {
            for (Card.Values v: Card.Values.values()) {
                this.cards.add(new Card(s, v));
            }
        }
    }

    /**
     * Constructor used for a card list given as commandline argument.
     * @param file The file containing the list of cards to be added to the deck.
     * @throws FileNotFoundException
     */
    public CardDeck(String file) throws FileNotFoundException {
        String[] cardList = readCardDeckFile(file);
        this.cards = new ArrayList<Card>();
        for (String cardString: cardList) {
            char[] cardCharArray = cardString.toCharArray();
            Card.Suits suit = getSuit(cardCharArray[0]);
            Card.Values value = getValue(cardCharArray[1]);
            if (suit != null && value != null) {
                this.cards.add(new Card(suit, value));
            }
        }
    }

    /**
     * Translates a character into a card suit.
     * @param suitChar The suit of a card to be created.
     * @return enum of a card suit.
     */
    private Card.Suits getSuit(Character suitChar) {
        switch (suitChar) {
            case 'C': return Card.Suits.C;
            case 'D': return Card.Suits.D;
            case 'H': return Card.Suits.H;
            case 'S': return Card.Suits.S;
        }
        return null;
    }

    /**
     * Translates a Character into a cards face value.
     * @param valueChar Character representing the face value of a card.
     * @return enum of a cards face value.
     */
    private Card.Values getValue(Character valueChar) {
        if (Character.isDigit(valueChar) && Character.getNumericValue(valueChar) != 0) {
            if (valueChar == 1){
                return Card.Values.TEN;
            }
            return Card.Values.values()[Character.getNumericValue(valueChar)-1];
        }
        switch (valueChar) {
            case 'A': return Card.Values.ACE;
            case 'J': return Card.Values.JACK;
            case 'Q': return Card.Values.QUEEN;
            case 'K': return Card.Values.KING;
        }
        return null;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Reads a file containing a list of cards to be generated.
     * @param file File with cards.
     * @return Array of strings representing all the cards to be added to a deck.
     * @throws FileNotFoundException
     */
    private String[] readCardDeckFile(String file) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String[] cardString = bufferedReader.readLine().split(", ");
            return cardString;
        } catch (IOException e) {
            System.out.println("No content in file");
            e.printStackTrace();
        }
        return new String[0];
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        Card drawnCard = this.cards.get(0);
        this.cards.remove(drawnCard);
        return drawnCard;
    }
}
