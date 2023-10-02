
package workingWithAbstractionEx.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        Bag bag = new Bag(bagCapacity);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {
            String itemSubName = input[i];
            long itemsCount = Long.parseLong(input[i + 1]);

            Item item = new Item(itemSubName, itemsCount);

            if (bag.isItemSkipped(item)) continue;

            bag.putItemsInTheBag(item);
        }

        System.out.println(bag);
    }
}