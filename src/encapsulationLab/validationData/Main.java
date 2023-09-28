package encapsulationLab.validationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            try {
                people.add(new Person(firstName, lastName, age, salary));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        people.forEach(person -> {
            person.increaseSalary(bonus);
            System.out.println(person);
        });
    }
}
