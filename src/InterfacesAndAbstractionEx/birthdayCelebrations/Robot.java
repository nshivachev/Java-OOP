package InterfacesAndAbstractionEx.birthdayCelebrations;

public class Robot implements Identifiable {

    private String id;
    private String model;

    Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
