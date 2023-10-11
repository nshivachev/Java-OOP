package InterfacesAndAbstractionEx.militaryElite;

public enum MissionState {
    IN_PROGRESS("inProgress"),
    FINISHED("finished");

    private String stateValue;

    MissionState(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getStateValue() {
        return stateValue;
    }

    public static MissionState parse(String text) {
        switch (text) {
            case "inProgress":
                return IN_PROGRESS;
            case "finished":
                return FINISHED;
            default:
                throw new IllegalArgumentException("Invalid mission");
        }
    }
}
