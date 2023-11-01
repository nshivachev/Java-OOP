package reflectionAndAnnotationsEx.barracksWars.core.commands;

import reflectionAndAnnotationsEx.barracksWars.interfaces.Executable;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
