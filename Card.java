
public class Card {

    public static final int HEART = 1;
    public static final int DIAMOND = 2;
    public static final int SPADES = 3;
    public static final int CLUBS = 4;

    public static final int NUM_SUITS = 4;
    public static final int CARD_MAX_VALUE = 13;
    public static final int NUM_CARDS = NUM_SUITS * CARD_MAX_VALUE;

    private int value;
    private int suit;

    private int score;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
        setScore();
    }

    private void setScore() {
        if (value > 1 && value < 11) {
            score = value;
        } else if (value > 10) {
            score = 10;
        } else {
            score = 11;
        }
    }

    public int score() {
        return score;
    }

    private String valueToString() {
        switch (value) {
            case 1:
                return "Ace" ;
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            default:
                return "King";
        }
    }

    private String suitToString() {
        switch (suit) {
            case HEART:
                return "heart";
            case DIAMOND:
                return "diamond";
            case SPADES:
                return "spades";
            default:
                return "clubs";
        }
    }

    public String toString() {
        return valueToString() + " of " + suitToString();
    }
}
