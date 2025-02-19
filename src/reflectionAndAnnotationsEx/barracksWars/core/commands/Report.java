package reflectionAndAnnotationsEx.barracksWars.core.commands;

import reflectionAndAnnotationsEx.barracksWars.anotations.Inject;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;

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
