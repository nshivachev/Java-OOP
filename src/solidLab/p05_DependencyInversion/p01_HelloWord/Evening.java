package solidLab.p05_DependencyInversion.p01_HelloWord;

public class Evening extends HelloWorld {
    @Override
    public String greeting(String name) {
        return "Good evening, " + name;
    }
}
