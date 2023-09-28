package encapsulationLab.sortByNameAndAge;

import java.util.Collections;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    static void sortPeople(List<Person> people) {
        Collections.sort(people, (firstPerson, secondPerson) -> {
            int result = firstPerson.firstName.compareTo(secondPerson.firstName);

            if (result == 0) {
                return Integer.compare(firstPerson.age, secondPerson.age);
            } else {
                return result;
            }
        });
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}
