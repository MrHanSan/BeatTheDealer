package main.java;

import java.io.FileNotFoundException;

/**
 * Class containing the game logic, and instances of actors and a deck.
 */
public class Game {
    private Actor dealer;
    private Actor player;
    private CardDeck deck;

    /**
     * Constructor adding actors and a deck of cards to the game.
     * @param file Possible file to use to create a dec of cards. If null, a full random deck is added to the game.
     */
    public Game(String[] file) {
        if (file.length == 0) {
            this.deck = new CardDeck();
            this.deck.shuffle();
        }
        else {
            try {
                this.deck = new CardDeck(file[0]);
            }
            catch (FileNotFoundException e) {
                System.out.println("The file given does not exist.");
                e.printStackTrace();
            }
        }
        this.dealer = new Actor("dealer");
        this.player = new Actor("sam");
    }

    /**
     * Main game, using some other functions to check for win conditions, draw cards and displaying winner.
     */
    public void playGame() {
        dealCards();
        Actor winner = blackJackOrTwentyTwo();
        if (winner == null) {
            while (!this.checkHoldCondition(this.player)) {
                player.drawCard(this.deck);
            }
            while (!this.checkHoldCondition(this.dealer) && player.getScore() < 22) {
                dealer.drawCard(this.deck);
            }
            winner = getWinner();
        }
        endGame(winner);
    }

    /**
     * Deals the initial two cards to actors.
     */
    private void dealCards() {
        for (int i=0; i<2; i++) {
            this.player.drawCard(this.deck);
            this.dealer.drawCard(this.deck);
        }
    }

    private Boolean checkHoldCondition(Actor actor) {
        if (!actor.getName().equals("dealer")) {
            return this.player.getScore() >= 17;
        }
        else {
            return this.dealer.getScore() >= player.getScore();
        }
    }

    private Actor blackJackOrTwentyTwo() {
        if (player.getScore() == 21) {
            return player;
        }
        else if (player.getScore() == 22 && dealer.getScore() == 22) {
            return dealer;
        }
        else if (dealer.getScore() == 21) {
            return dealer;
        }
        return null;
    }

    private Actor getWinner() {
        if (this.player.getScore() < 22 && this.dealer.getScore() < 22) {
            if (this.player.getScore() > this.dealer.getScore()) {
                return this.player;
            }
            else {
                return this.dealer;
            }
        }
        else if (player.getScore() > 21) {
            return this.dealer;
        }
        else if (this.dealer.getScore() > 21) {
            return this.player;
        }
        return null;
    }

    private void endGame(Actor winner) {
        System.out.println(winner.getName());
        System.out.println("sam: " + player.createCardListString());
        System.out.println("dealer: " + dealer.createCardListString());
    }
}
