import java.util.ArrayList;
import java.util.List;

public class Player implements HasHand {
    Deck deck = Deck.getInstance();
    List<Card> hand = new ArrayList<>();

    @Override
    public void drawCard() {
        Card drawnCard = this.deck.drawCard();
        this.hand.add(drawnCard);
    }

    @Override
    public int getHandValue() {
        int sum = 0;
        int acesInHand = 0;

        for (Card card : hand) {
            if (card.getRank().matches("[2-9]")) {
                sum += Integer.parseInt(card.getRank());
                continue;
            }

            sum += 10;
            if (card.getRank().equals("A")) {
                sum++;
                acesInHand++;
            }
        }

        while (sum > 21 && acesInHand > 0) {
            sum -= 10;
            acesInHand--;
        }

        return sum;
    }

    @Override
    public String getHand() {
        StringBuilder hand = new StringBuilder();
        for (Card card : this.hand) {
            hand.append(card).append(" ");
        }
        hand.append("> sum of " + this.getHandValue());
        return hand.toString();
    }
}