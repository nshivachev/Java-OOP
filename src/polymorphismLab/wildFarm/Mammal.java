package polymorphismLab.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWight, String livingRegion) {
        super(animalName, animalType, animalWight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(food.getQuantity());
        } else {
            System.out.println(this instanceof Mouse
                    ? "Mice are not eating that type of food!"
                    : super.getAnimalType() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                new DecimalFormat("#.##").format(getAnimalWight()),
                livingRegion,
                getFoodEaten());
    }
}
