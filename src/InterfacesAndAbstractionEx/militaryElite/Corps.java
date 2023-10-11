package InterfacesAndAbstractionEx.militaryElite;

public enum Corps {
    AIR_FORCES("Airforces"),
    MARINES("Marines");


    private String forcesType;

    Corps(String forcesType) {
        this.forcesType = forcesType;
    }

    public String getForcesType() {
        return forcesType;
    }

    public static Corps parse(String text) {
        switch (text) {
            case "Airforces":
                return AIR_FORCES;
            case "Marines":
                return MARINES;
            default:
                throw new IllegalArgumentException("Invalid corps");
        }
    }
}
