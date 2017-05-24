
public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    public Card askForCard(Dealer dealer) {
        Card card = null;
        if (this.score() < 16) {
            card = dealer.deal();
        } else {
            stand = true;
        }
        return card;
    }
}
