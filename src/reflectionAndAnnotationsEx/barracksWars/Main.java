package reflectionAndAnnotationsEx.barracksWars;

import reflectionAndAnnotationsEx.barracksWars.core.Engine;
import reflectionAndAnnotationsEx.barracksWars.core.commands.CommandInterpreterImpl;
import reflectionAndAnnotationsEx.barracksWars.core.factories.UnitFactoryImpl;
import reflectionAndAnnotationsEx.barracksWars.data.UnitRepository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.CommandInterpreter;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Runnable;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
