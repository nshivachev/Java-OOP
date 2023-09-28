package encapsulationEx.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String[] doughData = scanner.nextLine().split("\\s+");

        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        Pizza pizza;
        Dough dough;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
            dough = new Dough(flourType, bakingTechnique, doughWeight);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        pizza.setDough(dough);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] toppingData = input.split("\\s+");

            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);

            Topping topping;

            try {
                topping = new Topping(toppingType, toppingWeight);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            pizza.addTopping(topping);

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
