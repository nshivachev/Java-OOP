package workingWithAbstractionEx.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private Map<String, LinkedHashMap<String, Long>> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new LinkedHashMap<>();
    }

    void putItemsInTheBag(Item item) {
        String itemName = item.getName();
        String itemSubName = item.getSubName();
        long itemsCount = item.getCount();

        items.putIfAbsent(itemName, new LinkedHashMap<>());
        Map<String, Long> items = this.items.get(itemName);
        items.putIfAbsent(itemSubName, 0L);
        items.put(itemSubName, items.get(itemSubName) + itemsCount);
    }

    boolean isItemSkipped(Item item) {
        String itemName = item.getName();
        long itemsCount = item.getCount();

        if (itemName.isEmpty() || isBagFull(capacity, itemsCount)) {
            return true;
        }

        if ("Gem".equals(itemName)) {
            if (!items.containsKey(itemName)) {
                if (items.containsKey("Gold")) {
                    if (itemsCount > getCollectedItemsCount("Gold")) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (getCollectedItemsCount(itemName) + itemsCount > getCollectedItemsCount("Gold")) {
                return true;
            }
        } else if ("Cash".equals(itemName)) {
            if (!items.containsKey(itemName)) {
                if (items.containsKey("Gem")) {
                    if (itemsCount > getCollectedItemsCount("Gold")) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (getCollectedItemsCount(itemName) + itemsCount > getCollectedItemsCount("Gem")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        items.forEach((key, value) -> {
            long sumValues = value.values().stream().mapToLong(l -> l).sum();
            sb.append(String.format("<%s> $%s%n", key, sumValues));
            value.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> sb.append("##").append(i.getKey()).append(" - ").append(i.getValue()).append(System.lineSeparator()));
        });

        return sb.toString();
    }

    private long getCollectedItemsCount(String itemName) {
        return items.get(itemName).values().stream().mapToLong(e -> e).sum();
    }

    private boolean isBagFull(long bagCapacity, long itemsCount) {
        return bagCapacity < items.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + itemsCount;
    }
}
