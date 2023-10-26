package reflectionAndAnnotationsLab.gettersAndSetters;

import reflectionAndAnnotationsLab.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;

        Method[] methods = reflectionClass.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        Arrays.stream(methods).forEach(method -> {
            String methodName = method.getName();

            if (methodName.contains("get")) {
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }
        });

        getters.forEach(getter ->
                System.out.printf("%s will return class %s%n",
                        getter.getName(), getter.getReturnType().getName()));

        setters.forEach(setter ->
                System.out.printf("%s and will set field of class %s%n",
                        setter.getName(), setter.getParameterTypes()[0].getName()));
    }
}
