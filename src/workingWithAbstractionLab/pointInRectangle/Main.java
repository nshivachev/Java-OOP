package workingWithAbstractionLab.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = getCoordinates(scanner);

        int n = Integer.parseInt(scanner.nextLine());

        Point a = new Point(coordinates[0], coordinates[1]);
        Point c = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(a, c);

        while (n-- > 0) {
            int[] currentCoordinates = getCoordinates(scanner);

            int x = currentCoordinates[0];
            int y = currentCoordinates[1];

            Point point = new Point(x, y);

            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
