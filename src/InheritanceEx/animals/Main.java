package InheritanceEx.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!"Beast!".equals(animalType)) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            Animal animal;

            try {
                switch (animalType) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kittens":
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }

                System.out.println(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = scanner.nextLine();
        }
    }
}
