package polymorphismEx.vehicles;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Vehicle car;
    private static Vehicle truck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double fuelQuantity;
        double litersPerKm;

        String[] carInfo = scanner.nextLine().split("\\s+");
        fuelQuantity = Double.parseDouble(carInfo[1]);
        litersPerKm = Double.parseDouble(carInfo[2]);

        car = new Car(fuelQuantity, litersPerKm);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        fuelQuantity = Double.parseDouble(truckInfo[1]);
        litersPerKm = Double.parseDouble(truckInfo[2]);

        truck = new Truck(fuelQuantity, litersPerKm);

        int linesNumber = Integer.parseInt(scanner.nextLine());

        while (linesNumber-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];

            if ("Drive".equals(command)) {
                double distance = Double.parseDouble(tokens[2]);
                driveVehicle(vehicleType, distance);
            } else if ("Refuel".equals(command)) {
                double fuelLiters = Double.parseDouble(tokens[2]);
                refuelVehicle(vehicleType, fuelLiters);
            }
        }

        printVehicles(car, truck);
    }

    private static Vehicle getVehicle(String vehicleType) {
        return "Car".equals(vehicleType) ? car : truck;
    }

    private static void driveVehicle(String vehicleType, double distance) {
        try {
            System.out.println(getVehicle(vehicleType).driving(distance));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void refuelVehicle(String vehicleType, double fuelLiters) {
        getVehicle(vehicleType).refueling(fuelLiters);
    }

    private static void printVehicles(Vehicle... vehicles) {
        Arrays.stream(vehicles).forEach(System.out::println);
    }
}
