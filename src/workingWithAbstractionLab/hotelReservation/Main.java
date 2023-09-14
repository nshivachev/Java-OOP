package workingWithAbstractionLab.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] reservationInfo = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(reservationInfo[0]);
        int days = Integer.parseInt(reservationInfo[1]);
        Season season = Season.parse(reservationInfo[2]);
        Discount discount = Discount.parse(reservationInfo[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discount);

        System.out.printf("%.2f", priceCalculator.calculatePrice());
    }
}
