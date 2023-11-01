package reflectionAndAnnotationsEx.barracksWars.core.factories;

import reflectionAndAnnotationsEx.barracksWars.interfaces.Unit;
import reflectionAndAnnotationsEx.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "reflectionAndAnnotationsEx.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
