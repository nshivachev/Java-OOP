package solidLab.p05_DependencyInversion.p01_HelloWord;

import java.time.LocalDateTime;

public class Morning extends HelloWorld {
    @Override
    public String greeting(String name) {
        return "Good morning, " + name;
    }
}
