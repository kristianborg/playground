package nl.krisborg.playground.blackjack;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 26-6-13
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class Deck {

    private int numDecks;
    private List<Card> cards = null;
    private static final Random RANDOM = new Random(1);

    public Deck(int numDecks){
        this.numDecks = numDecks;
        reset();
        shuffle();
    }

    public void reset(){
        cards = new ArrayList<Card>();
        for(int i = 0; i < 4*numDecks; i++){
            cards.add(new Card("Ace", 11));
            cards.add(new Card("Jack", 10));
            cards.add(new Card("Queen", 10));
            cards.add(new Card("King", 10));
            for (int j = 2; j <= 10; j++){
                cards.add(new Card(Integer.toString(j), j));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards, RANDOM);
    }

    public Card getCard(){
        return cards.remove(0);
    }

    public int getSize(){
        return cards.size();
    }
}
