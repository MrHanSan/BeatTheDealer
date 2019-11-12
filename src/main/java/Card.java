package main.java;

public class Card {
    public enum Suits {D, C, H, S};
    public enum Values {ACE(11, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"),
                        SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"),
                        TEN(10, "10"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");
        private final int score;
        private final String faceForOutput;
        Values(int score, String faceForOutput) {
            this.score = score;
            this.faceForOutput = faceForOutput;
        }
    };

    private Suits suit;
    private Values value;

    public Card(Suits suit, Values value) {
        this.suit = suit;
        this.value = value;
    }

    public Suits getSuit() {
        return suit;
    }

    public String getFaceForOutput() {
        return this.value.faceForOutput;
    }

    public int getScore() {
        return this.value.score;
    }
}
