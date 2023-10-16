package polymorphismEx.vehiclesExtension;

public class Bus extends VehicleImpl {

    private static final double INCREASED_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, INCREASED_CONSUMPTION);
    }
}
