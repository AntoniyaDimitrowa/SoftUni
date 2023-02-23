package P03_CardsWithPower;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private int power;

    public Card(String cardSuit, String cardRank) {
        this.cardSuit = CardSuit.valueOf(cardSuit);
        this.cardRank = CardRank.valueOf(cardRank);
        this.power = this.cardSuit.getValue() + this.cardRank.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank.name(), this.cardSuit.name(), this.power);
    }
}
