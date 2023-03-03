package P05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        if(this.players.contains(player)) {
            throw new IllegalArgumentException("Player already exists.");
        }
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean playerFound = false;
        for (Player player : this.players) {
            if(player.getName().equals(playerName)) {
                this.players.remove(player);
                playerFound = true;
                break;
            }
        }
        if(!playerFound) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }
    }

    public double getRating() {
        double result = 0;
        for (Player player : this.players) {
            result += player.overallSkillLevel();
        }
        return result / this.players.size();
    }
}
