package reflectionAndAnnotationsEx.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionAndAnnotationsEx.barracksWars.anotations.Inject;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];

        try {
            repository.removeUnit(unitType);
        } catch (IllegalArgumentException | ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }

        return unitType + " retired!";
    }
}
