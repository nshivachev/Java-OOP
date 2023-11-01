package reflectionAndAnnotationsEx.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
