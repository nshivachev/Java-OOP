package polymorphismEx.vehicles;

public class Car extends VehicleImpl {

    private static final double INCREASED_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASED_CONSUMPTION);
    }
}
