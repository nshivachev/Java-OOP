package InterfacesAndAbstractionEx.foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int peopleNumber = Integer.parseInt(scanner.nextLine());

        while (peopleNumber-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String id = tokens[2];

            Person person = tokens.length == 3
                    ? new Rebel(name, age, id)
                    : new Citizen(name, age, id, tokens[3]);

            people.add(person);
        }

        String personName = scanner.nextLine();

        while (!"End".equals(personName)) {
            for (Person person : people) {
                if (person.getName().equals(personName)) {
                    person.buyFood();
                }
            }

            personName = scanner.nextLine();
        }

        System.out.println(people.stream().mapToInt(Buyer::getFood).sum());
    }
}
