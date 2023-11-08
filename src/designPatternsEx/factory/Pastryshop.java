package designPatternsEx.factory;

import designPatternsEx.factory.cake.Cake;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Pastryshop {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CakeFactory cakeFactory = new CakeFactory();

        Cake biscuitCake = cakeFactory.createCake("BiscuitCake", 2.0, 3.0, 5);
        Cake chocolateCake = cakeFactory.createCake("ChocolateCake", 1.0, 7.0, 15);
        Cake spinachCake = cakeFactory.createCake("SpinachCake", 8.0, 4.0, 10);
        Cake whiteCake = cakeFactory.createCake("WhiteCake", 12.0, 13.0, 25);

        List.of(biscuitCake, chocolateCake, spinachCake, whiteCake).forEach(Pastryshop::orderCake);
    }

    private static void orderCake(Cake biscuitCake) {
        biscuitCake.prepare();
        biscuitCake.bake();
        biscuitCake.box();
    }
}
