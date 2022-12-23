import java.util.Collections;
import java.util.Stack;

public class Deck {
    private static Deck instance;
    private Stack<Card> cards;

    private Deck() {
        this.reset();
    }

    public void reset() {
        cards = new Stack<>();
        char[] suits = {Card.HEART, Card.DIAMOND, Card.SPADE, Card.CLUB};
        for (char suit : suits) {
            for (int i = 1; i <= 13; i++) {
                String rank = switch (i) {
                    case 1 -> "A";
                    case 11 -> "J";
                    case 12 -> "Q";
                    case 13 -> "K";
                    default -> String.valueOf(i);
                };
                this.cards.push(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public static Deck getInstance() {
        if (Deck.instance == null) {
            Deck.instance = new Deck();
        }
        return Deck.instance;
    }

    public Card drawCard() {
        return this.cards.pop();
    }
}
