package InterfacesAndAbstractionEx.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");

            Birthable birthable;

            String kind = tokens[0];
            String name = tokens[1];

            if ("Citizen".equals(kind)) {
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];

                birthableList.add(new Citizen(name, age, id, birthDate));
                
            } else if ("Pet".equals(kind)) {
                String birthDate = tokens[2];

                birthableList.add(new Pet(name, birthDate));
            }

            command = scanner.nextLine();
        }

        String year = scanner.nextLine();

        birthableList
                .stream()
                .map(Birthable::getBirthDate)
                .filter(b -> b.endsWith(year))
                .forEach(System.out::println);
    }
}
