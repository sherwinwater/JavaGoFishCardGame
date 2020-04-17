package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * SYST 17796 Project Winter 2019 Base code.
 *
 * @Author: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
public class GoFishDeckTest {

    /**
     * Test of shuffle method, of class GoFishDeck.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards.add(card2);

        cards2.add(card2);
        cards2.add(card1);

        deck.setCards(cards);
        deck.shuffle();

        boolean expResult = true;
        boolean result = deck.getCards().contains(card1) && deck.getCards().contains(card1);
        assertEquals(expResult, result);
    }

    @Test
    public void testShuffleBoundary() {
        System.out.println("shuffleBoundary");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards2.add(card1);
        deck.setCards(cards);
        deck.shuffle();

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testShuffleBad() {
        System.out.println("shuffleBad");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);

        deck.shuffle();

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCard method, of class GoFishDeck.
     */
    @Test
    public void testRemoveCardGood() {
        System.out.println("removeCardGood");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        cards2.add(card2);
        cards2.add(card3);

        deck.setCards(cards);
        deck.removeCard(card1);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardBoundary() {
        System.out.println("removeCardBoundary");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards.add(card2);
        cards2.add(card2);
        deck.setCards(cards);
        deck.removeCard(card1);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardBad() {
        System.out.println("removeCardBad");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);

        cards.add(card1);

        deck.setCards(cards);
        deck.removeCard(card1);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCards method, of class GoFishDeck.
     */
    @Test
    public void testRemoveCardsGood() {
        System.out.println("removeCardsGood");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

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

        cards3.add(card4);
        cards3.add(card5);
        cards3.add(card6);
        cards3.add(card7);
        cards3.add(card8);
        cards3.add(card9);

        deck.setCards(cards);
        deck.removeCards(cards2);

        ArrayList<GoFishCard> expResult = cards3;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardsBoundary() {
        System.out.println("removeCardsBoundary");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards2.add(card1);
        cards3.add(card2);

        deck.setCards(cards);
        deck.removeCards(cards2);

        ArrayList<GoFishCard> expResult = cards3;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveCardsBad() {
        System.out.println("removeCardsBad");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        ArrayList<GoFishCard> cards3 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

        cards.add(card1);
        cards2.add(card1);

        deck.setCards(cards);
        deck.removeCards(cards2);

        ArrayList<GoFishCard> expResult = cards3;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of DispatchOneCard method, of class GoFishDeck.
     */
    @Test
    public void testDispatchOneCardGood() {
        System.out.println("DispatchOneCardGood");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

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

        deck.setCards(cards);
        deck.DispatchOneCard();

        GoFishCard expResult = card1;
        GoFishCard result = deck.DispatchOneCard();
        assertEquals(expResult, result);

    }

    @Test
    public void testDispatchOneCardBoundary() {
        System.out.println("DispatchOneCardGoodBoundary");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

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

        deck.setCards(cards);

        GoFishCard expResult = card1;
        GoFishCard result = deck.DispatchOneCard();
        assertEquals(expResult, result);

    }

    @Test
    public void testDispatchOneCardBad() {
        System.out.println("DispatchOneCardBad");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards2.add(card1);
        deck.setCards(cards);

        GoFishCard expResult = card1;
        GoFishCard result = deck.DispatchOneCard();
        assertEquals(expResult, result);

    }

    /**
     * Test of DispatchStartCards method, of class GoFishDeck.
     */
    @Test
    public void testDispatchStartCardsGood() {
        System.out.println("DispatchStartCardsGood");
        int numOfStartCards = 3;
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

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

        deck.setCards(cards);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.DispatchStartCards(numOfStartCards);
        assertEquals(expResult, result);
    }

    @Test
    public void testDispatchStartCardsBoundary() {
        System.out.println("DispatchStartCardsGoodBoundary");
        int numOfStartCards = 1;
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

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

        deck.setCards(cards);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.DispatchStartCards(numOfStartCards);
        assertEquals(expResult, result);
    }

    @Test
    public void testDispatchStartCardsBad() {
        System.out.println("DispatchStartCardsBad");
        int numOfStartCards = 0;
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);
        GoFishCard card4 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.ACE);
        GoFishCard card5 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.TEN);
        GoFishCard card6 = new GoFishCard(GoFishCard.Suit.SPADES, GoFishCard.Value.EIGHT);
        GoFishCard card7 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.EIGHT);
        GoFishCard card8 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.EIGHT);
        GoFishCard card9 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);

        deck.setCards(cards);

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.DispatchStartCards(numOfStartCards);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFirstCard method, of class GoFishDeck.
     */
    @Test
    public void testRemoveFirstCardGood() {
        System.out.println("removeFirstCardGood");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        cards2.add(card2);
        cards2.add(card3);

        deck.setCards(cards);
        deck.removeFirstCard();

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveFirstCardBad() {
        System.out.println("removeFirstCardBad");
        GoFishDeck deck = new GoFishDeck(52);

        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        GoFishCard card2 = new GoFishCard(GoFishCard.Suit.DIAMONDS, GoFishCard.Value.ACE);
        GoFishCard card3 = new GoFishCard(GoFishCard.Suit.HEARTS, GoFishCard.Value.ACE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        cards2.add(card3);

        deck.setCards(cards);
        deck.removeFirstCard();
        deck.removeFirstCard();

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveFirstCardBoundary() {
        System.out.println("removeFirstCardBoundary");
        GoFishDeck deck = new GoFishDeck(52);
        ArrayList<GoFishCard> cards = new ArrayList<>();
        ArrayList<GoFishCard> cards2 = new ArrayList<>();
        GoFishCard card1 = new GoFishCard(GoFishCard.Suit.CLUBS, GoFishCard.Value.ACE);
        cards.add(card1);
        deck.setCards(cards);
        deck.removeFirstCard();

        ArrayList<GoFishCard> expResult = cards2;
        ArrayList<GoFishCard> result = deck.getCards();
        assertEquals(expResult, result);
    }

}
