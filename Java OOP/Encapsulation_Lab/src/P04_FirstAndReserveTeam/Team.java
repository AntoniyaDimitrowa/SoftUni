package P04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    private void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    Team(String name) {
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();

        setName(name);
    }

    void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }
}
