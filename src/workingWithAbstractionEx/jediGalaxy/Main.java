package workingWithAbstractionEx.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPosition(scanner.nextLine());

        StarField starField = new StarField(dimensions[0], dimensions[1]);
        Galaxy galaxy = new Galaxy(starField);

        long collectedStars = 0;

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readPosition(command);
            int[] evilPosition = readPosition(scanner.nextLine());

            galaxy.moveEvil(evilPosition[0], evilPosition[1]);

            collectedStars += galaxy.moveJedi(jediPosition[0], jediPosition[1]);

            command = scanner.nextLine();

        }

        System.out.println(collectedStars);
    }

    private static int[] readPosition(String scanner) {
        return Arrays.stream(scanner.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}