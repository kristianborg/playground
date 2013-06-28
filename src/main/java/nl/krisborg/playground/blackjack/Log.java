package nl.krisborg.playground.blackjack;

/**
 * Created with IntelliJ IDEA.
 * User: kris
 * Date: 27-6-13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class Log {

    private static boolean enabled = false;

    public static void log(String message){
        if (enabled){
            System.out.println(message);
        }
    }
}
