package polymorphismLab.animals;

public abstract class Animal {

    String name;
    String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    abstract String explainSelf();
}
