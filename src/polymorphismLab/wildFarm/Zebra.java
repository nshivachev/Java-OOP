package polymorphismLab.wildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWight, String livingRegion) {
        super(animalName, animalType, animalWight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
