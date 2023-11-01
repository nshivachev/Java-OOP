package reflectionAndAnnotationsEx.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionAndAnnotationsEx.barracksWars.anotations.Inject;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }
}
