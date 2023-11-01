package reflectionAndAnnotationsEx.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String commandName = command.split("_")[0];
            int value = Integer.parseInt(command.split("_")[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));
        }
    }
}