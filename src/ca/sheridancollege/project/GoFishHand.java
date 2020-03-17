package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishHand extends GroupOfCards {

    private ArrayList<GoFishCard> cards = new ArrayList<>();
    private GoFishDeck deck;
    private int score = 0;
    private int size;//the size of the grouping

    public GoFishHand() {
        // TODO - implement GoFishHand.GoFishHand
        super(5);
    }

    public ArrayList<GoFishCard> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<GoFishCard> cards) {
        this.cards = cards;
    }

    public ArrayList<GoFishCard> showBook() {
        // map1 to find one book of cards
        // map2 to store and get the key for each card
        ArrayList<GoFishCard> book = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        for (int j = 0; j < cards.size(); j++) {
            GoFishCard card = cards.get(j);
            String key = card.getValue().toString();
            if (!map1.containsKey(key)) {
                map1.put(key, 1);
                map2.put(j, key);
            } else {
                map1.put(key, map1.get(key) + 1);
                map2.put(j, key);
            }
            if (map1.get(key) == 4) {
                for (HashMap.Entry<Integer, String> entry : map2.entrySet()) {
                    if (entry.getValue().equals(key)) {
                        book.add(cards.get(entry.getKey()));
                    }
                }
            }
        }

        return book;
    }

    public String askCard() {
        int size = this.cards.size();
        int indexRandom = (int) (Math.random() * size);
        String cardValue = String.valueOf(cards.get(indexRandom).getValue());
        return cardValue;
    }

    public void addCard(GoFishCard card) {
        cards.add(card);
    }

    public void drawOneCard(GoFishDeck deck) {
        this.cards.add(deck.getCards().get(0));
        deck.removeCard(deck.getCards().get(0));
    }

    public void removeCard(GoFishCard card) {
        cards.remove(card);
    }

    public void removeBook(ArrayList<GoFishCard> cards) {
        for (GoFishCard card : cards) {
            this.cards.remove(card);
        }
        score++;
    }

    public void drawUpFiveCards(GoFishDeck deck) {
        int i = 0;
        while (!deck.getCards().isEmpty() && i < 5) {
            cards.add(deck.getCards().get(0));
            deck.removeCard(deck.getCards().get(0));
            i++;
        }
    }

    public GoFishDeck getDeck() {
        return this.deck;
    }

    public void setDeck(GoFishDeck deck) {
        this.deck = deck;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
