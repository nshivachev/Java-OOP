package reflectionAndAnnotationsEx.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionAndAnnotationsEx.barracksWars.anotations.Inject;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Unit;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
