package solidLab.p05_DependencyInversion.p03_Database;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Integer> ids;
    List<String> names;

    public Data() {
        this.ids = new ArrayList<>();
        this.names = new ArrayList<>();
    }

    public Iterable<Integer> courseIds() {
        ids.add(1);
        ids.add(2);
        ids.add(3);

        return ids;
    }

    public Iterable<String> courseNames() {
        names.add("Java");
        names.add("C#");
        names.add("JavaScript");

        return names;
    }

    public Iterable<String> search(String substring) {
        List<String> substrings = new ArrayList<>();
        substrings.add(substring);

        return substrings;
    }

    public String getCourseById(int id) {
        int index = id - 1;

        if (index < 0 || index >= ids.size()) {
            throw new IllegalArgumentException("No such id");
        }

       return names.get(id - 1);
    }
}
