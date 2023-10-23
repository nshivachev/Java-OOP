package solidLab.p05_DependencyInversion.p01_HelloWord;

public class Main {
    public static void main(String[] args) {

        HelloWorld morning = new Morning();
        HelloWorld afternoon = new Afternoon();
        HelloWorld evening = new Evening();

        System.out.println(morning.greeting("Niki"));
        System.out.println(afternoon.greeting("Niki"));
        System.out.println(evening.greeting("Niki"));
    }
}
