package encapsulationEx.pizzaCalories;

public enum DoughTypes {
    WHITE(1.5),
    WHOLEGRAIN(1.0),
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private double doughModifier;
    DoughTypes(double doughModifier) {
        this.doughModifier = doughModifier;
    }

    public double getDoughModifierValue() {
            return doughModifier;
    }
}
