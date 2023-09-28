
package workingWithAbstractionEx.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        String[] items = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> itemsBag = new LinkedHashMap();

        long gold = 0;
        long gem = 0;
        long money = 0;

        for (int i = 0; i < items.length; i += 2) {
            String itemName = items[i];
            long itemsCount = Long.parseLong(items[i + 1]);

            String currentItemName = "";

            if (itemName.length() == 3) {
                currentItemName = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                currentItemName = "Gem";
            } else if (itemName.toLowerCase().equals("gold")) {
                currentItemName = "Gold";
            }

            if (currentItemName.equals("")) {
                continue;
            } else if (bagCapacity < itemsBag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + itemsCount) {
                continue;
            }

            switch (currentItemName) {
                case "Gem":
                    if (!itemsBag.containsKey(currentItemName)) {
                        if (itemsBag.containsKey("Gold")) {
                            if (itemsCount > itemsBag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemsBag.get(currentItemName).values().stream().mapToLong(e -> e).sum() + itemsCount > itemsBag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!itemsBag.containsKey(currentItemName)) {
                        if (itemsBag.containsKey("Gem")) {
                            if (itemsCount > itemsBag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemsBag.get(currentItemName).values().stream().mapToLong(e -> e).sum() + itemsCount > itemsBag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!itemsBag.containsKey(currentItemName)) {
                itemsBag.put((currentItemName), new LinkedHashMap<>());
            }

            if (!itemsBag.get(currentItemName).containsKey(itemName)) {
                itemsBag.get(currentItemName).put(itemName, 0L);
            }

            itemsBag.get(currentItemName).put(itemName, itemsBag.get(currentItemName).get(itemName) + itemsCount);

            if (currentItemName.equals("Gold")) {
                gold += itemsCount;
            } else if (currentItemName.equals("Gem")) {
                gem += itemsCount;
            } else if (currentItemName.equals("Cash")) {
                money += itemsCount;
            }
        }

        for (var item : itemsBag.entrySet()) {
            Long sumValues = item.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", item.getKey(), sumValues);

            item.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }
}