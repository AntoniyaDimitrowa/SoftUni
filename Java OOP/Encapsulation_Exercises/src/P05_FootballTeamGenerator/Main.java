package P05_FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final Map<String, Team> TEAMS = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            executeCommand(command);
            command = scanner.nextLine();
        }
    }

    private static void executeCommand(String command) {
        String[] commandArr = command.split(";");
        try {
            String teamName = commandArr[1];
            switch (commandArr[0]) {
                case "Team":
                    Team team = new Team(teamName);
                    TEAMS.put(teamName, team);
                    break;
                case "Add":
                    if(!TEAMS.containsKey(teamName)) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    } else {
                        String playerName = commandArr[2];
                        int endurance = Integer.parseInt(commandArr[3]);
                        int sprint = Integer.parseInt(commandArr[4]);
                        int dribble = Integer.parseInt(commandArr[5]);
                        int passing = Integer.parseInt(commandArr[6]);
                        int shooting = Integer.parseInt(commandArr[7]);

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        TEAMS.get(teamName).addPlayer(player);
                    }
                    break;
                case "Remove":
                    if(!TEAMS.containsKey(teamName)) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    } else {
                        String playerName = commandArr[2];
                        TEAMS.get(teamName).removePlayer(playerName);
                    }
                    break;
                case "Rating":
                    if(!TEAMS.containsKey(teamName)) {
                        throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                    } else {
                        System.out.println(teamName + " - " + Math.round(TEAMS.get(teamName).getRating()));
                    }
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
