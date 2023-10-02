package workingWithAbstractionEx.greedyTimes;

public class Item {
    private String name;
    private String subName;
    private long count;

    Item(String subName, long count) {
        setItemName(subName);
        this.subName = subName;
        this.count = count;
    }

    String getName() {
        return name;
    }

    String getSubName() {
        return subName;
    }

    long getCount() {
        return count;
    }

    private void setItemName(String name) {
        if (name.length() == 3) {
            this.name = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            this.name = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            this.name = "Gold";
        } else {
            this.name = "";
        }
    }
}
