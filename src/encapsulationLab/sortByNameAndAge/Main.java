package encapsulationLab.sortByNameAndAge;

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

            people.add(new Person(firstName, lastName, age));
        }

        Person.sortPeople(people);

        people.forEach(System.out::println);
    }
}
