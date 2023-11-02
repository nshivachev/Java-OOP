package exceptionsAndErrorHandling.numberInRange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        boolean isValidInput = false;

        while (!isValidInput) {
            String input = scanner.nextLine();

            String result = "Invalid number: " + input;

            try {
                int number = Integer.parseInt(input);
                if (isInBounds(number, range)) {
                    result = "Valid number: " + number;
                    isValidInput = true;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println(result);
        }
    }

    private static boolean isInBounds(int number, int[] range) {
        return number >= range[0] && number <= range[1];
    }
}
