package polymorphismLab.wildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWight = animalWight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWight() {
        return animalWight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    abstract void makeSound();

    abstract void eat(Food food);
}
