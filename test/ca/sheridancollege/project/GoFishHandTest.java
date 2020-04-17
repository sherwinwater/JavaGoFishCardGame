package ca.sheridancollege.project;

import ca.sheridancollege.project.GoFishCard.Suit;
import ca.sheridancollege.project.GoFishCard.Value;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * SYST 17796 Project Winter 2019 Base code.
 *
 * @Author: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
public class GoFishHandTest {

    /**
     * Test of getBook method(Good, Bad and Boundary),, of class GoFishHand.
     */
    @Test
    public void testGetBookGood() {
        System.out.println("getBookGood");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.EIGHT);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.FOUR);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        GoFishHand hand = new GoFishHand();
        hand.setCards(cards);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = hand.getBook();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetBookBoundary() {
        System.out.println("getBookBoundary");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        GoFishHand hand = new GoFishHand();
        hand.setCards(cards);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = hand.getBook();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetBookBad() {
        System.out.println("getBookBad");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        GoFishHand hand = new GoFishHand();
        hand.setCards(cards);

        ArrayList<GoFishCard> expResult = cards2;  // <[]>, nothing
        ArrayList<GoFishCard> result = hand.getBook();  // nothing
        assertEquals(expResult, result);

    }

    /**
     * Test of addCard method(Good, Bad and Boundary),, of class GoFishHand.
     */
    @Test
    public void testAddCardGood() {
        System.out.println("addCardGood");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.FOUR);
        cards.add(card);
        GoFishCard result = cards.get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    @Test
    public void testAddCardBad() {
        System.out.println("addCardBad");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.TEN);
        cards.add(card);
        GoFishCard result = cards.get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    @Test
    public void testAddCardBoundary() {
        System.out.println("addCardBoundary");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.ACE);
        cards.add(card);
        GoFishCard result = cards.get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    @Test
    /**
     * Test of drawnOneCard method(Good, Bad and Boundary),, of class
     * GoFishHand.
     */
    public void testdrawOneCardGood() {
        System.out.println("drawOneCardGood");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.SIX);
        cards.add(card);
        hand.setCards(cards);
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    @Test
    public void testdrawOneCardBad() {
        System.out.println("drawOneCardBad");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.KING);
        cards.add(card);
        hand.setCards(cards);
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    @Test
    public void testdrawOneCardBoundary() {
        System.out.println("drawOneCardBoundary");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.ACE);
        cards.add(card);
        hand.setCards(cards);
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCard method(Good, Bad and Boundary),, of class GoFishHand.
     */
    @Test
    public void testRemoveCardGood() {
        System.out.println("removeCardGood");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.TEN);
        GoFishCard card2 = new GoFishCard(Suit.CLUBS, Value.FIVE);
        cards.add(card);
        cards.add(card2);
        hand.setCards(cards);
        hand.removeCard(card);
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card2;
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardBad() {
        System.out.println("removeCardBad");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.CLUBS, Value.KING);
        cards.add(card);
        cards.add(card2);
        hand.setCards(cards);
        hand.removeCard(card);
        hand.removeCard(card2);
        int result = hand.getCards().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardBoundary() {
        System.out.println("removeCardBoundary");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.CLUBS, Value.KING);
        cards.add(card);
        cards.add(card2);
        hand.setCards(cards);
        hand.removeCard(card2);
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeBook method(Good, Bad and Boundary),, of class GoFishHand.
     */
    @Test
    public void testRemoveBookGood() {
        System.out.println("testRemoveBookGood");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> book = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        hand.setCards(cards);
        hand.removeBook(hand.getBook());
        GoFishCard result = hand.getCards().get(0);
        GoFishCard expResult = card5;
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveBookBad() {
        System.out.println("testRemoveBookBad");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> book = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        hand.setCards(cards);
        hand.removeBook(hand.getBook());
        int result = hand.getBook().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveBookBoundary() {
        System.out.println("testRemoveBookBoundary");
        GoFishHand hand = new GoFishHand();
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        hand.setCards(cards);
        hand.removeBook(hand.getBook());
        int result = hand.getCards().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of drawUpFiveCards method(Good, Bad and Boundary), of class
     * GoFishHand.
     */
    @Test
    public void testDrawUpFiveCardsGood() {
        System.out.println("drawUpFiveCardsGood");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.EIGHT);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);
        cards2.add(card5);

        deck.setCards(cards);
        hand.drawUpFiveCards(deck);
        ArrayList<GoFishCard> result = hand.getCards();
        ArrayList<GoFishCard> expResult = cards2;
        assertEquals(expResult, result);
    }

    @Test
    public void testDrawUpFiveCardsBoundary() {
        System.out.println("drawUpFiveCardsBoundary");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.EIGHT);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);
        cards2.add(card5);

        deck.setCards(cards);
        hand.drawUpFiveCards(deck);
        ArrayList<GoFishCard> result = hand.getCards();
        ArrayList<GoFishCard> expResult = cards2;
        assertEquals(expResult, result);
    }

    @Test
    public void testDrawUpFiveCardsBad() {
        System.out.println("drawUpFiveCardsBad");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishCard> cards = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        hand.drawUpFiveCards(deck);
        ArrayList<GoFishCard> result = hand.getCards();
        ArrayList<GoFishCard> expResult = cards;
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method(Good, Bad and Boundary),, of class GoFishHand.
     */
    @Test
    public void testGetScoreGood() {
        System.out.println("getScoreGood");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.EIGHT);
        GoFishCard card7 = new GoFishCard(Suit.CLUBS, Value.EIGHT);
        GoFishCard card8 = new GoFishCard(Suit.DIAMONDS, Value.EIGHT);
        GoFishCard card9 = new GoFishCard(Suit.HEARTS, Value.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);

        cards3.add(card6);
        cards3.add(card7);
        cards3.add(card8);
        cards3.add(card9);

        hand.setCards(cards);
        hand.removeBook(cards2);
        hand.removeBook(cards3);

        int expResult = 2;
        int result = hand.getScore();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScoreBad() {
        System.out.println("getScoreBad");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);

        hand.setCards(cards);

        int expResult = 0;
        int result = hand.getScore();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScoreBoundary() {
        System.out.println("getScoreBoundary");
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishHand hand = new GoFishHand();
        GoFishCard card1 = new GoFishCard(Suit.CLUBS, Value.ACE);
        GoFishCard card2 = new GoFishCard(Suit.DIAMONDS, Value.ACE);
        GoFishCard card3 = new GoFishCard(Suit.HEARTS, Value.ACE);
        GoFishCard card4 = new GoFishCard(Suit.SPADES, Value.ACE);
        GoFishCard card5 = new GoFishCard(Suit.SPADES, Value.TEN);
        GoFishCard card6 = new GoFishCard(Suit.SPADES, Value.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card3);
        cards2.add(card4);

        hand.setCards(cards);
        hand.removeBook(cards2);

        int expResult = 1;
        int result = hand.getScore();
        assertEquals(expResult, result);
    }

}
