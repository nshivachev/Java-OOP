package InterfacesAndAbstractionEx.collectionHierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        List<String> elementsToAdd = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        addElements(elementsToAdd, addCollection);
        addElements(elementsToAdd, addRemoveCollection);
        addElements(elementsToAdd, myList);

        int removeCount = Integer.parseInt(scanner.nextLine());

        removeElements(removeCount, addRemoveCollection);
        removeElements(removeCount, myList);
    }

    private static void addElements(List<String> elements, Addable collection) {
        elements.forEach(element -> System.out.print(collection.add(element) + " "));
        System.out.println();
    }

    private static void removeElements(int counter, AddRemovable collection) {
        while (counter-- > 0) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
