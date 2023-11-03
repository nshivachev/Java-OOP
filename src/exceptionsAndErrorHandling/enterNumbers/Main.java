package exceptionsAndErrorHandling.enterNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        int startIndex = 1;
        int endIndex = 100;

        while (numbers.size() < 10) {
            try {
                startIndex = readNumber(startIndex, endIndex, scanner);

                numbers.add(startIndex);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        if (!isInRange(number, start, end)) {
            throw new IllegalStateException(String.format("Your number is not in range %d - 100!", start));
        }

        return number;
    }

    private static boolean isInRange(int number, int startIndex, int endIndex) {
        return number > startIndex && number < endIndex;
    }
}
