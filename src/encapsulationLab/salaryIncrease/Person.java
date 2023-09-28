package encapsulationLab.salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        if (age < 30) {
            salary = salary + (salary * percentage / 200);
        } else {
            salary = salary + (salary * percentage / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, getSalary());
    }
}