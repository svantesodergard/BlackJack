public class Dealer extends Player {
    final int stayAt = 17;

    public void play() {
        while (this.getHandValue() < stayAt) {
            this.drawCard();
        }
    }

    @Override
    public String getHand() {
        if (this.hand.size() == 2) {
            return this.hand.get(0) + " XX";
        }
        return super.getHand();
    }
}
