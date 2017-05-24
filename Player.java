
import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected ArrayList<Card> hand = new ArrayList<>();
    protected boolean stand;

    public Player(String name) {
        this.name = name;
    }

    public abstract Card askForCard(Dealer dealer);

    public void standOrHit(Dealer dealer) {
        Card card = askForCard(dealer);
        if (card != null) {
            addToHand(card);
        }
    }

    public void addToHand(Card nextCard) {
        hand.add(nextCard);
    }

    public boolean stand() {
        return stand;
    }

    public boolean busted() {
        if (score() > 21) {
            return true;
        }
        return false;
    }

    public boolean notBusted() {
        return !busted();
    }

    public int score() {
        int totalScore = 0;
        for (Card card : hand) {
            if (card != null) {
                totalScore += card.score();
            }
        }
        return totalScore;
    }

    public String getName() {
        return name;
    }

    public void showHand() {
        System.out.print(toString()+" has: ");
        for (Card card : hand) {
            System.out.print(card.toString() + ",");
        }
        System.out.println();
    }
     public void aceFit() {
      int answ=1;
      int change=0;
           for (Card card : hand) {
             
           
        }
        System.out.println();
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Player) {
            Player other = (Player) o;
            return this.name.equals(other.name);
        }
        return false;
    }

}
