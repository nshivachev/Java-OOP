package reflectionAndAnnotationsEx.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        String input;
        while (!"HARVEST".equals(input = scanner.nextLine())) {
            Field fields[] = richSoilLandClass.getDeclaredFields();

            Consumer<Field> fieldConsumer = field ->
                    System.out.printf("%s %s %s%n",
                            Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(),
                            field.getName());

            String finalInput = input;
            Predicate<Field> fieldPredicate = field ->
                    Modifier.toString(field.getModifiers()).equals(finalInput);

            if (input.equals("all")) stream(fields).forEach(fieldConsumer);
            else stream(fields).filter(fieldPredicate).forEach(fieldConsumer);
        }
    }
}
