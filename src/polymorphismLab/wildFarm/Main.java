package polymorphismLab.wildFarm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Animal, Food> animals = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Animal currentAnimal = null;

        int lineCount = 0;

        String command;

        while (!"End".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");

            if (lineCount++ % 2 == 0) {
                currentAnimal = animalFactory(tokens);
            } else {
                animals.put(currentAnimal, foodFactory(tokens));
            }
        }

        printAnimals();
    }

    private static void printAnimals() {
        animals.forEach((animal, food) -> {
            animal.makeSound();
            animal.eat(food);
        });

        animals.forEach((animal, food) -> System.out.println(animal));
    }

    private static Food foodFactory(String[] tokens) {
        String foodType = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        return "Meat".equals(foodType) ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal animalFactory(String[] tokens) {
        String animalType = tokens[0];
        String animalName = tokens[1];
        double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        Animal animal;

        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Cat":
                String catBreed = tokens[4];
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            default:
                throw new IllegalArgumentException("No such animal: " + animalType);
        }

        return animal;
    }
}
