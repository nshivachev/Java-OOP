package designPatternsLab.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements SingletonContainer {
    private static SingletonDataContainer instance;
    private Map<String, Integer> capitals;

    private SingletonDataContainer() {
        capitals = new HashMap<>();
        System.out.println("Initializing singleton object");
    }

    @Override
    public int getPopulation(Map<String, Integer> capitals, String name) {
        return capitals.get(name);
    }

    public static SingletonDataContainer getInstance() {
        if (instance == null) {
            instance = new SingletonDataContainer();
        }
        return instance;
    }
}
