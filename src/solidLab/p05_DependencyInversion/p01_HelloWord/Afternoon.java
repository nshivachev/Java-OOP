package solidLab.p05_DependencyInversion.p01_HelloWord;

public class Afternoon extends HelloWorld {
    @Override
    public String greeting(String name) {
        return "Good afternoon, " + name;
    }
}
