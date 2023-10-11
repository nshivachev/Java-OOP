package InterfacesAndAbstractionEx.militaryElite;

public interface Mission {
    String getCodeName();
    MissionState getState();
    void completeMission();
}
