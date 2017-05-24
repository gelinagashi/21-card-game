import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 public class Game {

    private Queue<Player> players = new LinkedList<>();
    private Player bustedPlayer;
    private ArrayList<Player> blackJackWinners = new ArrayList<>();
    private Dealer dealer;
    private int currentPlayer = 0;

    public Game(Queue<Player> players, Dealer dealer) {
      Scanner sc = new Scanner(System.in);

        this.players = players;
        this.dealer = dealer;
        dealer.shuffle();
        dealer.deal(players, 2);
    }

    public void play() {
        while (this.notOver()) {
            Player player = currentPlayer();
            player.standOrHit(dealer);
            if (player.busted()) {
                bustedPlayer(player);
                break;
            }
            if (player.score() == 21) {
                blackJackWinner(player);
            }
            switchTurn();
        }
        if (bustedPlayer != null) {
            System.out.println(bustedPlayer + " busted!");
            bustedPlayer.showHand();
        }
        for (Player player : players) {
            player.showHand();
        }
        if (blackJackWinners.size() > 0) {
            System.out.print("BlackJack Winner: ");
            for (Player player : blackJackWinners) {
                player.showHand();
            }
            System.out.println();
        } else {
            showWinners();
        }
    }

    public void showWinners() {
        if (players.size() > 0) {
            Player nextWinner = players.remove();
            for (Player nextPlayer : players) {
                if (nextPlayer.score() > nextWinner.score()) {
                    nextWinner = nextPlayer;
                }
            }
            System.out.println("Winner: " + nextWinner);
        }
    }

    public void blackJackWinner(Player player) {
        player = players.remove();
        blackJackWinners.add(player);
    }

    private void bustedPlayer(Player playerToRemove) {
        players.remove(playerToRemove);
        bustedPlayer = playerToRemove;
    }

    public Player currentPlayer() {
        return players.peek();
    }

    public void switchTurn() {
        if (players.size() > 0) {
            Player player = players.remove();
            players.add(player);
        }
    }

    public boolean allPlayersStand() {
        boolean allPlayersStand = true;
        for (Player player : players) {
            allPlayersStand = allPlayersStand && player.stand();
        }
        return allPlayersStand;
    }

    private boolean notOver() {
        return dealer.hasCards() && !allPlayersStand();
    }

    public static void main(String[] args) {
     boolean b=false;
      Scanner sc = new Scanner(System.in);


      while(!b){
        Queue players = new LinkedList();
        players.add(new ComputerPlayer("Dealer"));
        players.add(new HumanPlayer("Gelina"));


        Dealer dealer = new Dealer();
        Game game = new Game(players, dealer);
        game.play();
        System.out.print("Press Enter for stoping the game ");
        String s= sc.nextLine();
         if(s.equals(""))
        {b=true;}
    }
}}