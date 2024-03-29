package P04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Team {
    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    private void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Team(String name) {
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();

        this.setName(name);
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
