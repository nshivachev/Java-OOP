package solidLab.p05_DependencyInversion.p02_Worker;

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
