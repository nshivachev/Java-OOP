package encapsulationEx.animalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.printf("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, chicken.productPerDay());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
