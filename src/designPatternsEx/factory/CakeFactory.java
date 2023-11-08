package designPatternsEx.factory;

import designPatternsEx.factory.cake.Cake;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CakeFactory {
    private static final String CAKE_PACKAGE_NAME = "designPatternsEx.factory.cake.";
    public Cake createCake(String cakeType, double diameter, double price, int pieces) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cakeClass = Class.forName(CAKE_PACKAGE_NAME + cakeType);
        Constructor<Cake> constructor = cakeClass.getDeclaredConstructor(double.class, double.class, int.class);
        Cake cake = constructor.newInstance(diameter, price, pieces);

        return cake;
    }
}
