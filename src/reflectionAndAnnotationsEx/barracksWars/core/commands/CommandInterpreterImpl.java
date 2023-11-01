package reflectionAndAnnotationsEx.barracksWars.core.commands;

import reflectionAndAnnotationsEx.barracksWars.anotations.Inject;
import reflectionAndAnnotationsEx.barracksWars.interfaces.CommandInterpreter;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Executable;
import reflectionAndAnnotationsEx.barracksWars.interfaces.Repository;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME = "reflectionAndAnnotationsEx.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = parseCommandToClassName(commandName);
        Executable command = null;

        try {
            Class commandClass = Class.forName(className);
            Constructor<Command> constructor = commandClass.getDeclaredConstructor(String[].class);
            command = constructor.newInstance((Object) data);
            Field[] fields = commandClass.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    if (field.getType().equals(Repository.class)) {
                        field.setAccessible(true);
                        field.set(command, repository);
                    } else if (field.getType().equals(UnitFactory.class)) {
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }

    private static String parseCommandToClassName(String commandName) {
        String firstLetterUpperCase = commandName.substring(0, 1).toUpperCase();
        String restOfTheCommand = commandName.substring(1);

        return COMMANDS_PACKAGE_NAME + firstLetterUpperCase + restOfTheCommand;
    }
}
