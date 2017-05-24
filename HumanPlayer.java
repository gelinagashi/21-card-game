
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    public Card askForCard(Dealer dealer) {
        Card card = null;
        Scanner sc = new Scanner(System.in);
        showHand();

        String hitOrStand;
        
        do {
            System.out.println("Do you want to hit or stand? Type H or S: ");
            hitOrStand = sc.nextLine();
        } while (!hitOrStand.equalsIgnoreCase("S") && !hitOrStand.equalsIgnoreCase("H"));

        if (hitOrStand.equalsIgnoreCase("H")) {
            card = dealer.deal();
        } else {
            stand = true;
        }
        return card;
    }
}
