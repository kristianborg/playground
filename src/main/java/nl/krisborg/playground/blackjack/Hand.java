package nl.krisborg.playground.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 26-6-13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class Hand {

    private static final int MAX_SCORE = 21;

    private String name;
    private List<Card> cards = new ArrayList<Card>();

    public Hand(String name){
        this.name = name;
    }

    public void addCard(Card card){
        cards.add(card);
        Log.log(name + " got card: " + card.getName() + ". Total score: " + getScore());
    }

    public int getScore(){
        int score = 0;
        for (Card card : cards) {
            score += card.getValue();
        }

        for (Card card : cards) {
            if (score > MAX_SCORE && card.isAce()) {
                score-= 10;
            }
        }

        return score;
    }

    public boolean isDead(){
        return getScore() > MAX_SCORE;
    }

    public String getName() {
        return name;
    }
}
