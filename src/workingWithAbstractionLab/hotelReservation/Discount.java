package workingWithAbstractionLab.hotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    double discountFactor;

    Discount(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public static Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value " + str);
        }
    }
}
