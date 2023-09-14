package workingWithAbstractionLab.hotelReservation;

public class PriceCalculator {
    double pricePerDay;
    int days;
    Season season;
    Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        return pricePerDay * days * season.getMultiplier() * discount.getDiscountFactor();
    }
}
