package exceptionsAndErrorHandling.squareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            String result = number < 0.0 ? "Invalid" : String.format("%.2f", Math.sqrt(number));
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
