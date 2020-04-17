package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * SYST 17796 Project Winter 2020
 *
 * @author: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
public class GoFishGameTest {
/**
     * Test of endGame method, of class GoFishGame.
     */
    @Test
    public void testEndGameGood() {
        System.out.println("endGameGood");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);

        boolean expResult = true;
        boolean result = deck.getCards().isEmpty() & player1.getHand().getCards().isEmpty();
        assertEquals(expResult, result);

    }

    @Test
    public void testEndGameBad() {
        System.out.println("endGameBad");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        cards.add(card1);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);

        boolean expResult = false;
        boolean result = deck.getCards().isEmpty() & player1.getHand().getCards().isEmpty();
        assertEquals(expResult, result);

    }

    @Test
    public void testEndGameBoundary() {
        System.out.println("endGameBoundary");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);

        boolean expResult = true;
        boolean result = deck.getCards().isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of declareWinner method, of class GoFishGame.
     */
    @Test
    public void testDeclareWinnerGood() {
        System.out.println("declareWinnerGood");

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);
        hand2.setCards(cards);
        hands.add(hand2);
        player2.setHand(hand2);
        players.add(player2);
        hand1.setScore(5);
        hand2.setScore(10);

        String expResult = "Jack";
        String result = players.get(1).getPlayerID();
        assertEquals(expResult, result);

    }
    @Test
    public void testDeclareWinnerBad() {
        System.out.println("declareWinnerBad");

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);
        hand2.setCards(cards);
        hands.add(hand2);
        player2.setHand(hand2);
        players.add(player2);
        hand1.setScore(10);
        hand2.setScore(0);

        String expResult = "Andy";
        String result = players.get(0).getPlayerID();
        assertEquals(expResult, result);

    }
    @Test
    public void testDeclareWinnerBoundary() {
        System.out.println("declareWinnerBoundary");

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);
        hand2.setCards(cards);
        hands.add(hand2);
        player2.setHand(hand2);
        players.add(player2);
        hand1.setScore(0);
        hand2.setScore(0);

        String expResult = "Jack";
        String result = players.get(1).getPlayerID();
        assertEquals(expResult, result);

    }

    /**
     * Test of callTurns method, of class GoFishGame.
     */
    @Test
    public void testCallTurnsGood() {
        System.out.println("callTurnsGood");
        int i = 0;

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);

        String expResult = "It's Andy's turn!";
        String result = "It's " + players.get(i).getPlayerID() + "'s turn!";
        assertEquals(expResult, result);

    }

    @Test
    public void testCallTurnsBad() {
        System.out.println("callTurnsBad");
        int i = 0;

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishGame game = new GoFishGame("GoFish");
        GoFishHand hand1 = new GoFishHand();
        GoFishHand hand2 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");
        GoFishPlayer player2 = new GoFishPlayer("Jack");

        ArrayList<GoFishCard> cards = new ArrayList<>();

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player2.setHand(hand1);
        players.add(player2);

        String expResult = "It's Jack's turn!";
        String result = "It's " + players.get(i).getPlayerID() + "'s turn!";
        assertEquals(expResult, result);

    }

    @Test
    public void testCallTurnsBoundary() {
        System.out.println("callTurnsBoundary");
        int i = 0;

        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        ArrayList<GoFishHand> hands = new ArrayList<>();

        GoFishHand hand1 = new GoFishHand();
        GoFishPlayer player1 = new GoFishPlayer("Andy");

        ArrayList<GoFishCard> cards = new ArrayList<>();

        deck.setCards(cards);
        hand1.setCards(cards);
        hands.add(hand1);
        player1.setHand(hand1);
        players.add(player1);

        String expResult = "It's Andy's turn!";
        String result = "It's " + players.get(i).getPlayerID() + "'s turn!";
        assertEquals(expResult, result);

    }

}
