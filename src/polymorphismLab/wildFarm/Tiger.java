package polymorphismLab.wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWight, String livingRegion) {
        super(animalName, animalType, animalWight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(food.getQuantity());
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
