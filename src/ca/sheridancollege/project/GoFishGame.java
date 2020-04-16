/**
 * SYST 17796 Project Winter 2019 Base code.
 *
 * @Modifier: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.GoFishCard.Suit;
import ca.sheridancollege.project.GoFishCard.Value;
import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {

    private GoFishDeck deck;
    private ArrayList<GoFishPlayer> players = new ArrayList<>();
    private ArrayList<GoFishHand> hands = new ArrayList<>();
    private ArrayList<GoFishCard> cards = new ArrayList<>();
    private static int numOfPlayers;

    public GoFishGame(String givenName) {
        // TODO - implement GoFishGame.GoFishGame
        super(givenName);
    }

    public static void main(String[] args) {
        GoFishGame gofish = new GoFishGame("GoFish");
        System.out.println("welcome to " + gofish.getGameName());
        System.out.println("please choose player numbers: 2,3,or 4(Only 2 players now)");
        Scanner sc = new Scanner(System.in);
        numOfPlayers = sc.nextInt();
        gofish.startGame(numOfPlayers);

        gofish.play(); // while there is card in the desk and hand, continue play
        gofish.declareWinner();
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    @Override
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
     * Play the game.
     */
    @Override
    public void play() {

        if (!deck.getCards().isEmpty()) {

            Scanner sc = new Scanner(System.in);
            String res = "";
            for (int i = 0; i < numOfPlayers; i++) {
                if (!hands.get(i).getCards().isEmpty()) {
                    callTurns(i);
                    System.out.println("deck size: " + deck.getCards().size());
                    boolean isGofish = false;
                    while (!isGofish) {
                        isGofish = true;
                        int numOfAskCard = 0;
                        GoFishCard one = new GoFishCard(Suit.CLUBS, Value.ACE);

                        if (i == numOfPlayers - 1) {
                            System.out.println(players.get(0).getPlayerID() + "'s cards: " + hands.get(0).getCards());
//                            System.out.println("deck " + deck.getCards());

                            boolean isAskcard = false;
                            GoFishCard askedCard = new GoFishCard(Suit.CLUBS, Value.ACE);
                            while (!isAskcard) {

                                System.out.println("Only the following cards in your hand can be asked:");
                                System.out.println(players.get(i).getPlayerID() + "'s cards: " + hands.get(i).getCards());
                                System.out.println("Hey " + players.get(i).getPlayerID()
                                        + ",please choose the index of the card from 0 to "
                                        + (hands.get(i).getCards().size() - 1)
                                        + " to ask " + players.get(0).getPlayerID());

                                try {
                                    int indexOfCard = sc.nextInt();
                                    askedCard = hands.get(i).getCards().get(indexOfCard);
                                    isAskcard = hands.get(i).askCard(askedCard);

                                } catch (Exception e) {
                                    sc.nextLine();
                                }
                            }

                            // next is index 0
                            for (int sub = 0; sub < hands.get(0).getCards().size(); sub++) {
                                GoFishCard card = hands.get(0).getCards().get(sub);
                                if (card.equals(askedCard)) {
                                    hands.get(i).addCard(card);
                                    hands.get(0).removeCard(card);
                                    sub--;
                                    numOfAskCard++;
                                    one.setValue(card.getValue());
                                    isGofish = false;
                                }
                            }

                            if (!isGofish) {
                                res = players.get(0).getPlayerID() + " says I have " + numOfAskCard + " " + one.getValue();
                                System.out.println(res);

                                if (hands.get(0).getCards().isEmpty()) {
                                    hands.get(0).drawUpFiveCards(deck);
                                }
                            } else {
                                res = players.get(0).getPlayerID() + " says: gofish";
                                System.out.println(res);
                                System.out.println("deck " + deck.getCards());
                                if (!deck.getCards().isEmpty()) {
                                    hands.get(i).drawOneCard(deck.DispatchOneCard());
                                    deck.removeFirstCard();
                                    System.out.println(players.get(i).getPlayerID() + " draws one card from the deck.");
                                }
                                i = -1; // next player will be players[0] when it reaches end of the list
                            }

                            checkBook(numOfPlayers - 1);

                            if (endGame()) {
                                break;
                            }

                        } else {
                            System.out.println(players.get(i + 1).getPlayerID() + "'s cards: " + hands.get(i + 1).getCards());

                            boolean isAskcard = false;
                            GoFishCard askedCard = new GoFishCard(Suit.CLUBS, Value.ACE);
                            while (!isAskcard) {

                                System.out.println("Only the following cards in your hand can be asked:");
                                System.out.println(players.get(i).getPlayerID() + "'s cards: " + hands.get(i).getCards());
                                System.out.println("Hey " + players.get(i).getPlayerID()
                                        + ",please choose the index of the card from 0 to "
                                        + (hands.get(i).getCards().size() - 1)
                                        + " to ask " + players.get(i + 1).getPlayerID());
                                try {
                                    int indexOfCard = sc.nextInt();
                                    askedCard = hands.get(i).getCards().get(indexOfCard);
                                    isAskcard = hands.get(i).askCard(askedCard);

                                } catch (Exception e) {
                                    sc.nextLine();
                                }
                            }

                            for (int sub = 0; sub < hands.get(i + 1).getCards().size(); sub++) {
                                GoFishCard card = hands.get(i + 1).getCards().get(sub);
                                if (card.equals(askedCard)) {
                                    hands.get(i).addCard(card);
                                    hands.get(i + 1).removeCard(card);
                                    sub--;
                                    numOfAskCard++;
                                    one.setValue(card.getValue());
                                    isGofish = false;
                                }
                            }
                            if (!isGofish) {
                                res = players.get(i + 1).getPlayerID() + " says I have " + numOfAskCard + " " + one.getValue();
                                System.out.println(res);
                                if (hands.get(i + 1).getCards().isEmpty()) {
                                    hands.get(i + 1).drawUpFiveCards(deck);
                                }
                            } else {
                                res = players.get(i + 1).getPlayerID() + " says: gofish";
                                System.out.println(res);
//                                System.out.println("deck " + deck.getCards());
                                if (!deck.getCards().isEmpty()) {
                                    hands.get(i).drawOneCard(deck.DispatchOneCard());
                                    deck.removeFirstCard();
                                    System.out.println(players.get(i).getPlayerID() + " draws one card from the deck.");

                                }
                            }

                            checkBook(i);
                            if (endGame()) {
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("No cards in the deck!");
        }
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
//        System.out.println("deck's cards: " + cards);
        switch (numOfPlayers) {
            case 2: {
                Scanner sc = new Scanner(System.in);
                System.out.println("please input first player name: ");
                String nameOfPlayer1 = sc.nextLine();
                System.out.println("please input second player name: ");
                String nameOfPlayer2 = sc.nextLine();
                while (nameOfPlayer2.equalsIgnoreCase(nameOfPlayer1)) {
                    System.out.println("please input second player name: ");
                    nameOfPlayer2 = sc.nextLine();
                }

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

                hand1.setCards(cardsOfPlayer1);
                hand2.setCards(cardsOfPlayer2);

                hands.add(hand1);
                hands.add(hand2);
                player1.setHand(hand1);
                player2.setHand(hand2);

                players.add(player1);
                players.add(player2);

//                System.out.println(players.get(0).getPlayerID() + "'s cards: "
//                        + hands.get(0).getCards());
//                System.out.println(players.get(1).getPlayerID() + "'s cards: "
//                        + hands.get(1).getCards());
            }
            break;
            case 3:
            case 4:
                break;
        }

    }

    public boolean endGame() {
        // TODO - implement GoFishGame.endGame
        boolean isEndGame = true;
        for (int i = 0; i < this.players.size(); i++) {
            if (!hands.get(i).getCards().isEmpty()) {
                isEndGame = false;
            }
        }
        if (deck.getCards().isEmpty() && isEndGame) {
            System.out.println("Game over");
        }
        return isEndGame;
    }

    public void callTurns(int i) {
        // TODO - implement GoFishGame.callTurns

        System.out.println("It's " + players.get(i).getPlayerID() + "'s turn");

    }

    public void checkBook(int i) {
        ArrayList<GoFishCard> book = hands.get(i).getBook();
        if (!book.isEmpty()) {
            System.out.println(players.get(i).getPlayerID() + " says I have a book : " + book);
            hands.get(i).removeBook(hands.get(i).getBook());

            if (hands.get(i).getCards().isEmpty()) {
                hands.get(i).drawUpFiveCards(deck);
            }
        }

    }

}
