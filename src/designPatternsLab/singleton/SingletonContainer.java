package designPatternsLab.singleton;

import java.util.Map;

public interface SingletonContainer {
    int getPopulation(Map<String, Integer> capitals, String name);
}
