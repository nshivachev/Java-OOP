package encapsulationEx.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isPlayerRemoved = players.removeIf(player -> player.getName().equals(playerName));

        if (!isPlayerRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, getName()));
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
