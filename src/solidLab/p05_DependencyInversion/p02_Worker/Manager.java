package solidLab.p05_DependencyInversion.p02_Worker;

public class Manager implements Worker, Sleeper {

    @Override
    public void work() {
        System.out.println("Manager is working");
    }

    @Override
    public void sleep() {
        System.out.println("Manager is sleeping");
    }
}
