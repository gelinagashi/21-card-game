
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


public class Dealer {

    private ArrayList<Card> deck = new ArrayList<>();
    private int nextCardIndex;

    public Dealer() {
        for (int suit = 1; suit <= Card.NUM_SUITS; suit++) {
            for (int value = 1; value < Card.CARD_MAX_VALUE; value++) {
                deck.add(new Card(value, suit));
            }
        }
    }

    public Card deal() {
        Card card = null;
        if (hasCards()) {
            card = deck.remove(nextCardIndex++);
        }
        return card;
    }

    public void deal(Player player) {
        player.addToHand(deal());
    }

    public void deal(Queue<Player> players, int noOfCards) {
        for (int i = 0; i < noOfCards; i++) {
            for (Player player : players) {
                deal(player);
            }
        }
    }

    public boolean hasCards() {
        return deck.size() > 0;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}
