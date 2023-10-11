package InterfacesAndAbstractionEx.militaryElite;

import java.util.List;

public interface Engineer extends SpecialisedSoldier {

    void addRepair(RepairImpl repair);
    List<RepairImpl> getRepairs();
}
