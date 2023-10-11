package InterfacesAndAbstractionEx.militaryElite;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Soldier> soldiers = new ArrayList<>();
    private static Map<Integer, Private> privates = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (soldierType) {
                case "Private":
                    double privateSalary = Double.parseDouble(tokens[4]);
                    addPrivate(id, firstName, lastName, privateSalary);
                    break;
                case "LieutenantGeneral":
                    double lieutenantSalary = Double.parseDouble(tokens[4]);
                    addLieutenant(id, firstName, lastName, lieutenantSalary, tokens);
                    break;
                case "Engineer":
                    try {
                        double engineerSalary = Double.parseDouble(tokens[4]);
                        Corps engineeCorps = Corps.parse(tokens[5]);
                        addEngineer(id, firstName, lastName, engineerSalary, engineeCorps, tokens);
                    } catch (IllegalArgumentException ignored) {}
                    break;
                case "Commando":
                    try {
                        double commandoSalary = Double.parseDouble(tokens[4]);
                        Corps commandoCorps = Corps.parse(tokens[5]);
                        addCommando(id, firstName, lastName, commandoSalary, commandoCorps, tokens);
                    } catch (IllegalArgumentException ignored) {}
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    addSpy(id, firstName, lastName, codeNumber);
                    break;
            }

            input = scanner.nextLine();
        }

        soldiers.forEach(System.out::println);
    }

    private static void addSpy(int id, String firstName, String lastName, String codeNumber) {
        soldiers.add(new SpyImpl(id, firstName, lastName, codeNumber));
    }

    private static void addCommando(int id, String firstName, String lastName, double commandoSalary, Corps commandoCorps, String[] tokens) {
        Commando commando = new CommandoImpl(id, firstName, lastName, commandoSalary, commandoCorps);

        for (int i = 6; i < tokens.length; i += 2) {
            String missionCodeName = tokens[i];
            String missionStateInput = tokens[i + 1];

            try {
                MissionState missionState = MissionState.parse(missionStateInput);

                commando.addMission(new MissionImpl(missionCodeName, missionState));
            } catch (IllegalArgumentException ignored) {}
        }

        soldiers.add(commando);
    }

    private static void addEngineer(int id, String firstName, String lastName, double engineerSalary, Corps engineeCorps, String[] tokens) {
        Engineer engineer = new EngineerImpl(id, firstName, lastName, engineerSalary, engineeCorps);

        for (int i = 6; i < tokens.length; i += 2) {
            String partName = tokens[i];
            int hoursWorked = Integer.parseInt(tokens[i + 1]);

            engineer.addRepair(new RepairImpl(partName, hoursWorked));
        }

        soldiers.add(engineer);
    }

    private static void addLieutenant(int id, String firstName, String lastName, double lieutenantSalary, String[] tokens) {
        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, lieutenantSalary);

        for (int i = 5; i < tokens.length; i++) {
            int privateId = Integer.parseInt(tokens[i]);

            lieutenantGeneral.addPrivate(privates.get(privateId));
        }

        soldiers.add(lieutenantGeneral);
    }

    private static void addPrivate(int id, String firstName, String lastName, double privateSalary) {
        Private priv = new PrivateImpl(id, firstName, lastName, privateSalary);

        privates.put(id, priv);
        soldiers.add(priv);
    }
}
