import java.util.Scanner;

public class Blackjack {
    Dealer dealer;
    Player player;
    Scanner playerChoice = new Scanner(System.in);

    public Blackjack() {
        do {
            newGame();
            System.out.println("Want to play another? [Y]es or [N]o");
        } while (playerChoice.nextLine().equalsIgnoreCase("Y"));
    }

    public void newGame() {
        dealer = new Dealer();
        player = new Player();

        for (int i = 0; i < 2; i++) {
            dealer.drawCard();
        }

        player.drawCard();
        do {
            player.drawCard();
            this.showHands();
            if (player.getHandValue() < 21 && dealer.getHandValue() != 21) {
                System.out.println("Do you want another card? [H]it Me or [S]tand");
            } else {
                break;
            }
        } while (playerChoice.nextLine().equalsIgnoreCase("H"));

        dealer.play();
        showHands();
        endGame();
    }

    public void endGame() {
        String winner = dealer.getHandValue() > player.getHandValue() ? "Dealer" : "Player";
        if (player.getHandValue() > 21) {
            System.out.println("Player has gone bust");
            winner = "Dealer";
        } else if (player.hand.size() >= 5) {
            System.out.println("Five Card Charlie pays 5 to 1!");
            winner = "Player";
        } else if (dealer.getHandValue() > 21) {
            System.out.println("Dealer has gone bust");
            winner = "Player";
        } else if (player.getHandValue() == dealer.getHandValue()) {
            System.out.println("It is a Tie!");
            return;
        }
        System.out.println("The win goes to the " + winner);
    }

    public void showHands() {
        System.out.println("-------------------------");
        System.out.println("Dealers Hand:");
        System.out.println(dealer.getHand());
        System.out.println();
        System.out.println("Your Hand:");
        System.out.println(player.getHand());
    }

    public static void main(String[] args) {
        new Blackjack();
    }
}
