package InheritanceLab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {
    public Object getRandomElement() {
        return remove(new Random().nextInt(super.size()));
    }
}
