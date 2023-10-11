package InterfacesAndAbstractionEx.militaryElite;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return missions;
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator()).append("Missions:");
        missions.forEach(mission -> sb.append(System.lineSeparator()).append("  ").append(mission.toString()));

        return sb.toString();
    }
}
