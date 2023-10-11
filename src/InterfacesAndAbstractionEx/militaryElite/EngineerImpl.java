package InterfacesAndAbstractionEx.militaryElite;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<RepairImpl> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        repairs = new ArrayList<>();
    }

    @Override
    public List<RepairImpl> getRepairs() {
        return repairs;
    }

    @Override
    public void addRepair(RepairImpl repair) {
        repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator()).append("Repairs:");
        repairs.forEach(repair -> sb.append(System.lineSeparator()).append("  ").append(repair.toString()));

        return sb.toString();
    }
}
