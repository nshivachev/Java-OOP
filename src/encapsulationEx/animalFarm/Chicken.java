package encapsulationEx.animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0 || age > 15) {
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggs;

        if (age < 6) {
            eggs = 2;
        } else if (age < 12) {
            eggs = 1;
        } else {
            eggs = 0.75;
        }

        return eggs;
    }

    @Override
    public String toString() {
        return "";
    }
}
