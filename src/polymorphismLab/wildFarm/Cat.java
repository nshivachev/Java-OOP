package polymorphismLab.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWight, String livingRegion, String breed) {
        super(animalName, animalType, animalWight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                breed,
                new DecimalFormat("#.##").format(getAnimalWight()),
                super.getLivingRegion(),
                getFoodEaten());
    }
}
