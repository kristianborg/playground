package nl.krisborg.playground.blackjack;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 26-6-13
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {

    private static final int GAMES_PER_RUN = 2000;

    public void run(){
        List<Tactic> playerTactics = Arrays.asList(
                new Tactic(11),
                new Tactic(12),
                new Tactic(13),
                new Tactic(14),
                new Tactic(15),
                new Tactic(16),
                new Tactic(17),
                new Tactic(18),
                new Tactic(19),
                new Tactic(20)
        );

        Tactic bankTactic = new Tactic(17);

        for (Tactic playerTactic : playerTactics) {
            Game game = new Game(playerTactic, bankTactic, false, GAMES_PER_RUN);
            game.play();
            game.printResult();
        }
        System.out.println();
        for (Tactic playerTactic : playerTactics) {
            Game game = new Game(playerTactic, bankTactic, true, GAMES_PER_RUN);
            game.play();
            game.printResult();
        }
    }

    public static void main(String[] argv){
        new Calculator().run();
    }

}
