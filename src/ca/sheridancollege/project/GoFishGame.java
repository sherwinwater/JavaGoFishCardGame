package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {

    private GoFishDeck deck;
    private ArrayList<GoFishPlayer> players = new ArrayList<>();
    private ArrayList<GoFishHand> hands = new ArrayList<>();
    private ArrayList<GoFishCard> cards = new ArrayList<>();

    public GoFishGame(String givenName) {
        // TODO - implement GoFishGame.GoFishGame
        super(givenName);
    }

    public static void main(String[] args) {
        GoFishGame gofish = new GoFishGame("GoFish");
        System.out.println("welcome to " + gofish.getGameName());
        System.out.println("please choose player numbers: 2,3,or 4");
        Scanner sc = new Scanner(System.in);
        int numOfPlayers = sc.nextInt();

        gofish.startGame(numOfPlayers);

        gofish.play(); // while there is card in the desk and hand, continue play

        // once there is no card, declare winner and end game
        gofish.declareWinner();
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public void declareWinner() {
        // TODO - implement GoFishGame.declareWinner
        System.out.println("players'score: ");
        int max = 0;
        String winner = "";
        for (int i = 0; i < this.players.size(); i++) {
            System.out.println(players.get(i).getPlayerID() + " : "
                    + players.get(i).getHand().getScore());
            if (players.get(i).getHand().getScore() > max) {
                max = players.get(i).getHand().getScore();
                winner = players.get(i).getPlayerID();
            }
        }
        System.out.println("winner: " + winner + "  score: " + max);
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public void play() {

        if (!deck.getCards().isEmpty()) {

            Scanner sc = new Scanner(System.in);
            String res = new String();
            for (int i = 0; i < this.players.size(); i++) {
                if (!hands.get(i).getCards().isEmpty()) {
                    System.out.println("it's " + players.get(i).getPlayerID() + "'s turn");
                    System.out.println(players.get(i).getPlayerID() + "'s cards: "
                            + hands.get(i).getCards());

                    boolean isGofish = false;
                    while (!isGofish) {
                        isGofish = true;

                        if (i == this.players.size() - 1) {
                            System.out.println(players.get(0).getPlayerID() + "'s cards: "
                                    + hands.get(0).getCards());

                            System.out.println(players.get(0).getPlayerID()
                                    + ": do you have any rank of ");
                            String askCard = sc.nextLine();

                            // next is index 0
                            for (int sub = 0; sub < hands.get(0).getCards().size(); sub++) {
                                GoFishCard card = hands.get(0).getCards().get(sub);
                                String value = String.valueOf(card.getValue());

                                if (value.equalsIgnoreCase(askCard)) {
                                    hands.get(this.players.size() - 1).addCard(card);
                                    hands.get(0).removeCard(card);
                                    sub--;
                                    res = "I have i = -1  " + card.getValue();
                                    isGofish = false;
                                    System.out.println(res);
                                }
                            }

                            if (hands.get(0).getCards().isEmpty()) {
                                hands.get(0).drawUpFiveCards(deck);
                            }

                            if (isGofish) {
                                i = -1; // next player will be players[0] when it reaches end of the list
                                res = "gofish";
                                hands.get(this.players.size() - 1).drawOneCard(deck);
                                System.out.println("deck " + deck.getCards());
                                System.out.println(res);
                            }

                            ArrayList<GoFishCard> book = hands.get(this.players.size() - 1).showBook();
                            if (!book.isEmpty()) {
                                System.out.println("I have a book : " + book);
                                hands.get(this.players.size() - 1).removeBook(book);

                                if (hands.get(this.players.size() - 1).getCards().isEmpty()) {
                                    hands.get(this.players.size() - 1).drawUpFiveCards(deck);
                                }
                            }
                            if (hands.get(0).getCards().isEmpty()) {
                                System.out.println("Game Over");
                                break;
                            }
                        } else {
                            System.out.println(players.get(i + 1).getPlayerID() + "'s cards: "
                                    + hands.get(i + 1).getCards());

                            System.out.println(players.get(i + 1).getPlayerID()
                                    + ": do you have any rank of ");
                            String askCard = sc.nextLine();

                            for (int sub = 0; sub < hands.get(i + 1).getCards().size(); sub++) {
                                GoFishCard card = hands.get(i + 1).getCards().get(sub);
                                String value = String.valueOf(card.getValue());

                                if (value.equalsIgnoreCase(askCard)) {
                                    hands.get(i).addCard(card);  
                                    hands.get(i + 1).removeCard(card);
                                    sub--;
                                    res = "I have " + card.getValue();
                                    isGofish = false;
                                    System.out.println(res);
                                }
                            }

                            if (hands.get(i + 1).getCards().isEmpty()) {
                                hands.get(i + 1).drawUpFiveCards(deck);
                            }

                            if (isGofish) {
                                res = "gofish";
                                hands.get(i).drawOneCard(deck);
                                System.out.println("deck " + deck.getCards());
                                System.out.println(res);
                            }
                            ArrayList<GoFishCard> book = hands.get(i).showBook();
                            if (!book.isEmpty()) {
                                System.out.println("I have a book : " + book);
                                hands.get(i).removeBook(book);
                                if (hands.get(i).getCards().isEmpty()) {
                                    hands.get(i).drawUpFiveCards(deck);
                                }
                            }

                            if (hands.get(i + 1).getCards().isEmpty()) {
                                System.out.println("Game Over");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public GoFishDeck getDeck() {
        return this.deck;
    }

    /**
     *
     * @param deck
     */
    public void setDeck(GoFishDeck deck) {
        this.deck = deck;
    }

//    @Override
//	public ArrayList<GoFishPlayer> getPlayers() {
//		return this.players;
//	}
//	public void setPlayers(ArrayList<GoFishPlayer> players) {
//		this.players = players;
//	}
    public void startGame(int numOfPlayers) {
        this.deck = new GoFishDeck(52);
        this.deck.initDeck();
        this.deck.shuffle();
        this.cards = deck.getCards();
        System.out.println("c " + cards);
        switch (numOfPlayers) {
            case 2: {
                Scanner sc = new Scanner(System.in);
                System.out.println("please input first player name: ");
                String nameOfPlayer1 = sc.nextLine();
                System.out.println("please input second player name: ");
                String nameOfPlayer2 = sc.nextLine();

                GoFishPlayer player1 = new GoFishPlayer(nameOfPlayer1);
                GoFishPlayer player2 = new GoFishPlayer(nameOfPlayer2);
                GoFishHand hand1 = new GoFishHand();
                GoFishHand hand2 = new GoFishHand();

                ArrayList<GoFishCard> cardsOfPlayer1 = new ArrayList<>();
                ArrayList<GoFishCard> cardsOfPlayer2 = new ArrayList<>();
                for (int i = 0; i < 10; i += 2) {
                    cardsOfPlayer1.add(cards.get(i));
                    cardsOfPlayer2.add(cards.get(i + 1));
                }
                deck.removeCards(cardsOfPlayer1);
                deck.removeCards(cardsOfPlayer2);
                System.out.println("deck " + deck.getCards());

                hand1.setCards(cardsOfPlayer1);
                hand2.setCards(cardsOfPlayer2);

                hands.add(hand1);
                hands.add(hand2);
                player1.setHand(hand1);
                player2.setHand(hand2);

                players.add(player1);
                players.add(player2);

                System.out.println(players.get(0).getPlayerID() + "'s cards: "
                        + hands.get(0).getCards());
                System.out.println(players.get(1).getPlayerID() + "'s cards: "
                        + hands.get(1).getCards());
            }
            break;
            case 3:
            case 4:
                break;
        }

    }

    public void endGame() {
        // TODO - implement GoFishGame.endGame
        throw new UnsupportedOperationException();
    }

    public void callTurns() {
        // TODO - implement GoFishGame.callTurns
        throw new UnsupportedOperationException();
    }

}
