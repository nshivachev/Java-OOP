package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Team> teams = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split(";");

            String action = tokens[0];
            String teamName = tokens[1];
            String playerName;

            try {
                switch (action) {
                    case "Team":
                        teams.add(new Team(teamName));
                        break;
                    case "Add":
                        playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);

                        getTeam(teamName).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        break;
                    case "Remove":
                        playerName = tokens[2];

                        getTeam(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        System.out.printf("%s - %d%n", teamName, Math.round(getTeam(teamName).getRating()));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown command " + command);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }
    }

    private static Team getTeam(String teamName) {
        validateIsTeamExist(teamName);
        
        return teams.stream().filter(team -> team.getName().equals(teamName)).findAny().get();
    }

    private static void validateIsTeamExist(String teamName) {
        boolean isTeamExist = teams.stream().anyMatch(team -> team.getName().equals(teamName));

        if (!isTeamExist) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }
}
