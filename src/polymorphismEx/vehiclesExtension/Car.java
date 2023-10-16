package polymorphismEx.vehiclesExtension;

public class Car extends VehicleImpl {

    private static final double INCREASED_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, INCREASED_CONSUMPTION);
    }
}
