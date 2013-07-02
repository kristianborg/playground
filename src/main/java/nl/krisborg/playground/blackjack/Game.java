package nl.krisborg.playground.blackjack;

/**
 * User: kris
 * Date: 28-6-13
 */
public class Game {

    private Deck deck = new Deck(3);
    private Player bank = new Player("Bank", new Tactic(17));
    private Player player;
    private boolean twentyoneRule;


    public Game(Player player, boolean twentyoneRule){
        this.player = player;
        this.twentyoneRule = twentyoneRule;
    }

    public void play(){
        bank.clearCards();
        player.clearCards();
        player.addCard(deck.getCard());
        bank.addCard(deck.getCard());
        player.addCard(deck.getCard());
        bank.addCard(deck.getCard());

        while(player.wantCard()){
            player.addCard(deck.getCard());
        }
        if (player.isDead()){
            Log.log(player.getName() +  " is dead");
            player.addGameResult(GameResult.LOST_DEAD);
            return;
        }

        if (twentyoneRule && bank.getScore() == 21){
            Log.log(bank.getName() +  " wins with 21");
            player.addGameResult(GameResult.LOST_TWENTYONERULE);
            return;
        }

        while(bank.wantCard()){
            bank.addCard(deck.getCard());
        }
        if (bank.isDead()){
            Log.log(bank.getName() +  " is dead");
            player.addGameResult(GameResult.WON_BANK_DEAD);
            return;
        }

        if (bank.getScore() > player.getScore()){
            Log.log(bank.getName() +  " wins with " + bank.getScore() + " vs " + player.getScore());
            player.addGameResult(GameResult.LOST_SCORE);
        } else if (player.getScore() > bank.getScore()){
            Log.log(player.getName() +  " wins with " + player.getScore() + " vs " + bank.getScore());
            player.addGameResult(GameResult.WON_SCORE);
        } else {
            Log.log("Players tie with " + player.getScore());
            player.addGameResult(GameResult.TIE);
        }
    }
}
