package workingWithAbstractionEx.cardsWithPower;

public class Card {
    private CardRanks rank;
    private CardSuits suit;
    private int power;

    public Card(CardRanks rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = rank.getRankPower() + suit.getSuitPower();
    }

    public CardRanks getRank() {
        return rank;
    }

    public CardSuits getSuit() {
        return suit;
    }

    public int getPower() {
        return power;
    }
}
