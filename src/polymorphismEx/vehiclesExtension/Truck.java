package polymorphismEx.vehiclesExtension;

public class Truck extends VehicleImpl {

    private static final double INCREASED_CONSUMPTION = 1.6;
    private static final double DECREASED_REFILING = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, INCREASED_CONSUMPTION);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * DECREASED_REFILING);
    }
}
