package nl.krisborg.playground.blackjack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: kris
 * Date: 2-7-13
 */
public class StatsUtils {

    private static final List<GameResult> WON_RESULTS = Arrays.asList(GameResult.WON_BANK_DEAD, GameResult.WON_SCORE);
    private static final List<GameResult> LOST_RESULTS = Arrays.asList(GameResult.LOST_DEAD, GameResult.LOST_SCORE, GameResult.LOST_TWENTYONERULE);
    private static final List<GameResult> TIE_RESULTS = Arrays.asList(GameResult.TIE);


    public static String getStats(List<GameResult> gameResults){
        int lost = 0;
        int won = 0;
        int tie = 0;

        Map<GameResult, Integer> gameResultOccurences = new HashMap<GameResult, Integer>();
        for (GameResult gameResult : gameResults) {
            if (WON_RESULTS.contains(gameResult)){
                won++;
            } else if (LOST_RESULTS.contains(gameResult)){
                lost++;
            } else if (TIE_RESULTS.contains(gameResult)){
                tie++;
            }

            Integer previousOccurence = gameResultOccurences.get(gameResult);
            if (previousOccurence == null){
                gameResultOccurences.put(gameResult, 1);
            } else {
                gameResultOccurences.put(gameResult, previousOccurence + 1);
            }
        }

        int totalResults = gameResults.size();
        String result = "";
        result += formatResult("won", totalResults, won);
        result += formatResult("lost", totalResults, lost);
        result += formatResult("tie", totalResults, tie);
        for(GameResult gameResult : GameResult.values()){
            int gameResultOccurence = gameResultOccurences.containsKey(gameResult) ? gameResultOccurences.get(gameResult) : 0;
            result += formatResult(gameResult.name(), totalResults, gameResultOccurence);
        }

        return result;
    }

    private static String formatResult(String title, int total, int occurence){
        return title + ": " + toPercentage(total, occurence) + " (" + occurence + "), ";
    }

    private static String toPercentage(int total, int occurence){
        double percentage = total == 0 ? 0 : ((double)(occurence * 100)) / total;
        return String.format("%5.1f", percentage);
    }
}
