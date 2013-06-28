package nl.krisborg.playground.blackjack;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 26-6-13
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
public class Card {

    private String name;
    private int value;

    public Card(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isAce(){
        return "Ace".equals(name);
    }
}
