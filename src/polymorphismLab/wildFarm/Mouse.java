package polymorphismLab.wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWight, String livingRegion) {
        super(animalName, animalType, animalWight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
