package InterfacesAndAbstractionEx.collectionHierarchy;

public class MyListImpl extends Collection implements MyList {

    @Override
    public int add(String element) {
        items.add(0, element);

        return items.indexOf(element);
    }

    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
