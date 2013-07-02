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

    private static final int GAMES_PER_RUN = 50000;

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

        for (Tactic tactic : playerTactics) {
            Player player = new Player("Kris", tactic);
            for(int i = 0; i < GAMES_PER_RUN; i++){
                Game game = new Game(player, true);
                game.play();
            }
            System.out.println(tactic.toString() + " - " + StatsUtils.getStats(player.getGameResults()));
        }
        System.out.println("=======");
        for (Tactic tactic : playerTactics) {
            Player player = new Player("Kris", tactic);
            for(int i = 0; i < GAMES_PER_RUN; i++){
                Game game = new Game(player, false);
                game.play();
            }
            System.out.println(tactic.toString() + " - " + StatsUtils.getStats(player.getGameResults()));
        }
    }

    public static void main(String[] argv){
        new Calculator().run();
    }

}
