package polymorphismEx.vehiclesExtension;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Vehicle car;
    private static Vehicle truck;
    private static Vehicle bus;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vehiclesCount = 3;

        createVehicles(vehiclesCount, scanner);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        manageVehicles(commandsCount, scanner);

        printVehicles(car, truck, bus);
    }

    private static void manageVehicles(int commandsCount, Scanner scanner) {
        while (commandsCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double distance = Double.parseDouble(tokens[2]);

            if ("Drive".equals(command)) {
                driveVehicle(vehicleType, distance);
            } else if ("Refuel".equals(command)) {
                double liters = Double.parseDouble(tokens[2]);
                refuelVehicle(vehicleType, liters);
            } else if ("DriveEmpty".equals(command)) {
                driveEmptyVehicle(vehicleType, distance);
            }
        }
    }

    private static void createVehicles(int vehicleCount, Scanner scanner) {
        while (vehicleCount-- > 0) {
            String[] vehicleInfo = scanner.nextLine().split("\\s+");

            String vehicleType = vehicleInfo[0];
            double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
            double litersPerKm = Double.parseDouble(vehicleInfo[2]);
            double tankCapacity = Double.parseDouble(vehicleInfo[3]);

            try {
                switch (vehicleType) {
                    case "Car":
                        car = new Car(fuelQuantity, litersPerKm, tankCapacity);
                        break;
                    case "Truck":
                        truck = new Truck(fuelQuantity, litersPerKm, tankCapacity);
                        break;
                    case "Bus":
                        bus = new Bus(fuelQuantity, litersPerKm, tankCapacity);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Vehicle getVehicle(String vehicleType) {
        Vehicle vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = car;
                break;
            case "Truck":
                vehicle = truck;
                break;
            case "Bus":
                vehicle = bus;
                break;
            default:
                break;
        }

        return vehicle;
    }

    private static void driveVehicle(String vehicleType, double distance) {
        try {
            System.out.println(getVehicle(vehicleType).driving(distance));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void driveEmptyVehicle(String vehicleType, double distance) {
        System.out.println(getVehicle(vehicleType).drivingEmpty(distance));
    }

    private static void refuelVehicle(String vehicleType, double fuelLiters) {
        try {
            getVehicle(vehicleType).refueling(fuelLiters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printVehicles(Vehicle... vehicles) {
        Arrays.stream(vehicles).forEach(System.out::println);
    }
}
