package InterfacesAndAbstractionEx.militaryElite;

import java.util.List;

public interface Commando extends SpecialisedSoldier {

    List<Mission> getMissions();
    void addMission(Mission mission);
}
