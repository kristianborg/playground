package nl.krisborg.playground.blackjack;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 27-6-13
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class Tactic {

    private int minScore;

    public Tactic(int minScore){
        this.minScore = minScore;
    }

    public boolean stop(Hand hand){
        return hand.getScore() >= minScore;
    }

    public String toString(){
        return "stop at " + minScore;
    }
}
