package workingWithAbstractionLab.rhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());

        printRow(row);
    }

    private static void printRow(int row) {
        for (int i = 1; i <= row; i++) {
            printFirstPattern(row, i, " ");
            printSecondPattern(i, "* ");

            System.out.println();
        }

        for (int i = 1; i <= row - 1; i++) {
            printSecondPattern(i + 1, " ");
            printFirstPattern(row - 1, i, "* ");

            System.out.println();
        }
    }

    private static void printFirstPattern(int row, int i, String printSymbol) {
        for (int j = row; j >= i; j--) {
            System.out.print(printSymbol);
        }
    }

    private static void printSecondPattern(int i, String printSymbol) {
        for (int j = 1; j <= i; j++) {
            System.out.print(printSymbol);
        }
    }
}