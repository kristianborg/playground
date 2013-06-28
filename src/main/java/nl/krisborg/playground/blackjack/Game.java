package nl.krisborg.playground.blackjack;

/**
 * User: kris
 * Date: 27-6-13
 */
public class Game {

    private static final int NUM_PACKS = 3;
    private static final int MIN_SIZE = 12;

    private Deck deck = new Deck(NUM_PACKS);
    private Tactic playerTactic;
    private Tactic bankTactic;
    int numGames;
    private boolean twentyoneRule;
    private int playerWins = 0;
    private int bankWins = 0;
    private int ties = 0;

    public Game(Tactic playerTactic, Tactic bankTactic, boolean twentyoneRule, int numGames){
        this.playerTactic = playerTactic;
        this.bankTactic = bankTactic;
        this.twentyoneRule = twentyoneRule;
        this.numGames = numGames;
    }

    public void play(){
        for (int i = 0; i < numGames; i++){
            while(deck.getSize() > MIN_SIZE){
                Log.log("Starting game");
                playGame();
            }
            deck.reset();
            deck.shuffle();
        }
    }

    public void printResult(){
        int totalGames = playerWins + bankWins + ties;
        System.out.print("tactic: " + playerTactic + ", ");
        System.out.print("twentyOneRule: " + (twentyoneRule ? "yes, " : "no , "));
        System.out.print("bankWins: " + bankWins + " (" + toPercentage(bankWins) + "), ");
        System.out.print("playerWins: " + playerWins + " (" + toPercentage(playerWins) + "), ");
        System.out.print("ties: " + ties + " (" + toPercentage(ties) + ")");
        System.out.println();
    }

    String toPercentage(double score){
        String result = Double.toString((score * 100) / (playerWins + bankWins + ties));
        return result.substring(0, 4) + "%";
    }

    private void playGame(){
        Hand bankHand = new Hand("Bank");
        Hand playerHand = new Hand("Kris");
        playerHand.addCard(deck.getCard());
        bankHand.addCard(deck.getCard());
        playerHand.addCard(deck.getCard());
        bankHand.addCard(deck.getCard());

        while(!playerTactic.stop(playerHand)){
            playerHand.addCard(deck.getCard());
        }
        if (playerHand.isDead()){
            Log.log(playerHand.getName() +  " is dead");
            bankWins++;
            return;
        }

        if (twentyoneRule && bankHand.getScore() == 21){
            Log.log(bankHand.getName() +  " wins with 21");
            bankWins++;
            return;
        }

        while(!bankTactic.stop(bankHand)){
            bankHand.addCard(deck.getCard());
        }
        if (bankHand.isDead()){
            Log.log(playerHand.getName() +  " is dead");
            playerWins++;
            return;
        }

        if (bankHand.getScore() > playerHand.getScore()){
            Log.log(bankHand.getName() +  " wins with " + bankHand.getScore() + " vs " + playerHand.getScore());
            bankWins++;
        } else if (playerHand.getScore() > bankHand.getScore()){
            Log.log(playerHand.getName() +  " wins with " + playerHand.getScore() + " vs " + bankHand.getScore());
            playerWins++;
        } else {
            Log.log("Players tie with " + playerHand.getScore());
            ties++;
        }
    }
}
