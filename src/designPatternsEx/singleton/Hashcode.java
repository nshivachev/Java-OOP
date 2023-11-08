package designPatternsEx.singleton;

public class Hashcode {
    private static String point;
    private static Hashcode instance;

    private Hashcode() {
        this.point = "A";
    }

    public static Hashcode getInstance() {
        if (instance == null) {
            instance = new Hashcode();
        }
        return instance;
    }
}
