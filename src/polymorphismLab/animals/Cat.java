package polymorphismLab.animals;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favourite food is %s%nMEEOW", name, favouriteFood);
    }
}
