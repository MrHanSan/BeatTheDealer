package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private ArrayList<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<Card>();
        for (Card.Suits s: Card.Suits.values()) {
            for (Card.Values v: Card.Values.values()) {
                this.cards.add(new Card(s, v));
            }
        }
    }

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

    private Card.Suits getSuit(Character suitChar) {
        switch (suitChar) {
            case 'C': return Card.Suits.C;
            case 'D': return Card.Suits.D;
            case 'H': return Card.Suits.H;
            case 'S': return Card.Suits.S;
        }
        return null;
    }

    private Card.Values getValue(Character valueChar) {
        if (Character.isDigit(valueChar) && Character.getNumericValue(valueChar) < 11) {
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
