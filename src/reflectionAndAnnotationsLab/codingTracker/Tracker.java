package reflectionAndAnnotationsLab.codingTracker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Tracker {
    @Author(name = "Georgi")
    public static void main(String[] args) throws NoSuchMethodException {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = (Author) method.getAnnotations()[0];
            System.out.printf("%s: %s()%n", annotation.name(), method.getName());
        }
    }
}
