package InterfacesAndAbstractionEx.birthdayCelebrations;

public class Pet implements Birthable {

    private String name;
    private String birthDate;

    Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
