package InterfacesAndAbstractionEx.collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String element) {
        items.add(0, element);

        return items.indexOf(element);
    }

    @Override
    public String remove() {
        return items.remove(items.size() - 1);
    }
}
