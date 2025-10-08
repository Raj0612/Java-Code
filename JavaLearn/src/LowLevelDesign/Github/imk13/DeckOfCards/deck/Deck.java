package LowLevelDesign.Github.imk13.DeckOfCards.deck;

import LowLevelDesign.Github.imk13.DeckOfCards.card.Cards;
import LowLevelDesign.Github.imk13.DeckOfCards.enums.Suite;

import java.util.ArrayList;


public class Deck {
    private ArrayList<Cards> cardsDeck = new ArrayList<>();

    public Deck() {
        for(int faceValue = 1; faceValue <= 13; faceValue++) {
            for(Suite suite: Suite.values()) {
                cardsDeck.add(new Cards(faceValue, suite));
            }
        }
    }

    /**
     * @return the cardsDeck
     */
    public ArrayList<Cards> getCardsDeck() {
        return cardsDeck;
    }
}