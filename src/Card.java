public class Card {
    public static char SPADE = '♠';
    public static char CLUB = '♣';
    public static char HEART = '♥';
    public static char DIAMOND = '◆';

    private char suit;
    private String rank;

    public char getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    Card(char suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.suit+this.rank;
    }
}
