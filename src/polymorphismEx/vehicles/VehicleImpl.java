package polymorphismEx.vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String driving(double distance) {
        String vehicleType = this.getClass().getSimpleName();
        double neededFuel = distance * fuelConsumption;

        if (neededFuel > fuelQuantity) {
            throw new IllegalArgumentException(vehicleType + " needs refueling");
        }

        fuelQuantity -= neededFuel;

        return String.format("%s travelled %s km", vehicleType, new DecimalFormat("##.##").format(distance));
    }

    @Override
    public void refueling(double liters) {
        fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new DecimalFormat("##.00").format(fuelQuantity));
    }
}
