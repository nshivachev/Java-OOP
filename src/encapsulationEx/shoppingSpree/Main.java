package encapsulationEx.shoppingSpree;

import java.util.*;

public class Main {
    private static Map<String, Person> people = new LinkedHashMap<>();
    private static Map<String, Product> products = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personData = scanner.nextLine().split(";");
        String[] productData = scanner.nextLine().split(";");

        try {
            addPersons(personData);
            addProducts(productData);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();

        while (!("END").equals(command)) {
            String[] currentCommand = command.split("\\s+");

            String personName = currentCommand[0];
            String productName = currentCommand[1];

            Person person = people.get(personName);
            Product product = products.get(productName);
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", person.getName(), product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }

    private static void addPersons(String[] personData) {
        Arrays.stream(personData).forEach(personInfo -> {
            String personName = personInfo.split("=")[0];
            double personMoney = Double.parseDouble(personInfo.split("=")[1]);

            people.put(personName, new Person(personName, personMoney));
        });
    }

    private static void addProducts(String[] productData) {
        Arrays.stream(productData).forEach(productInfo -> {
            String productName = productInfo.split("=")[0];
            double productCost = Double.parseDouble(productInfo.split("=")[1]);

            products.put(productName, new Product(productName, productCost));
        });
    }
}
