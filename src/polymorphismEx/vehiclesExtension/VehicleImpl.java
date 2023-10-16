package polymorphismEx.vehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double increasedConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity, double increasedConsumption) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption + increasedConsumption;
        this.tankCapacity = tankCapacity;
        this.increasedConsumption = increasedConsumption;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String driving(double distance) {
        String vehicleType = this.getClass().getSimpleName();

        double neededFuel = distance * fuelConsumption;

        if (neededFuel > fuelQuantity) {
            return vehicleType + " needs refueling";
        }

        fuelQuantity -= neededFuel;

        return String.format("%s travelled %s km", vehicleType, new DecimalFormat("##.##").format(distance));
    }

    @Override
    public String drivingEmpty(double distance) {
        fuelConsumption -= increasedConsumption;

        String result = driving(distance);

        fuelConsumption += increasedConsumption;

        return result;
    }

    @Override
    public void refueling(double liters) {
        if (liters + fuelQuantity > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new DecimalFormat("##.00").format(fuelQuantity));
    }
}
