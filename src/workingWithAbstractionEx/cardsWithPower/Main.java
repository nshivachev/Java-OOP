package workingWithAbstractionEx.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRanks rank = CardRanks.valueOf(scanner.nextLine());
        CardSuits suit = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(rank, suit);

        System.out.printf("Card name: %s of %s; Card power: %d", card.getRank(), card.getSuit(), card.getPower());
    }
}
