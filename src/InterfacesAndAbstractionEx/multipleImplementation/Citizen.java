package InterfacesAndAbstractionEx.multipleImplementation;

public class Citizen implements Identifiable, Person, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthDate;

    Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
