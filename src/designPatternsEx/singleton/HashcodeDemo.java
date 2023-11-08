package designPatternsEx.singleton;

public class HashcodeDemo {
    public static void main(String[] args) {
        Hashcode hashcode = Hashcode.getInstance();
        System.out.println(hashcode.hashCode());
    }
}
