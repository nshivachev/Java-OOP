package solidLab.p05_DependencyInversion.p02_Worker;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Robot robot = new Robot();

        manager.work();
        manager.sleep();
        robot.work();
    }
}
