package InterfacesAndAbstractionEx.militaryElite;

public class MissionImpl implements Mission {
    private String codeName;
    private MissionState state;

    public MissionImpl(String codeName, MissionState state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public MissionState getState() {
        return state;
    }

    @Override
    public void completeMission() {
        state = MissionState.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.getStateValue());
    }
}
