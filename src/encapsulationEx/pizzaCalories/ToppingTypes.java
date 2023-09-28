package encapsulationEx.pizzaCalories;

public enum ToppingTypes {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private double toppingModifier;
    ToppingTypes(double toppingModifier) {
        this.toppingModifier = toppingModifier;
    }

    public double getToppingModifier() {
        return toppingModifier;
    }
}
