package InheritanceLab.randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(1);
        randomArrayList.add(12);
        randomArrayList.add(123);
        randomArrayList.add(12345);
        randomArrayList.add(123456);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }
}
