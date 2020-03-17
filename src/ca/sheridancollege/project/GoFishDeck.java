package ca.sheridancollege.project;

import ca.sheridancollege.project.GoFishCard.Suit;
import ca.sheridancollege.project.GoFishCard.Value;
import java.util.ArrayList;
import java.util.Collections;

public class GoFishDeck extends GroupOfCards {

    private ArrayList<GoFishCard> cards = new ArrayList<>();
    private int size;

    public GoFishDeck(int givenSize) {
        super(givenSize);
        this.size = givenSize;
    }

    public ArrayList<GoFishCard> getCards() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void setCards(ArrayList<GoFishCard> cards) {
        this.cards = cards;
    }

    public void initDeck() {
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                this.cards.add(new GoFishCard(s, v));
            }
        }
    }

    public void removeCard(GoFishCard card) {
        cards.remove(card);
    }

    public void removeCards(ArrayList<GoFishCard> cards) {
        for (GoFishCard card : cards) {
            this.cards.remove(card);
        }
    }
}
