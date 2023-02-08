package P06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }

    public boolean hasPokemonWithElement(String element) {
        for (Pokemon currPokemon : this.getPokemons()) {
            if(currPokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void allPokemonsLoseHealth () {
        for (int i = 0; i < this.getPokemons().size(); i++) {
            this.getPokemons().get(i).loseHealth();
            if(this.getPokemons().get(i).getHealth() <= 0) {
                this.getPokemons().remove(i);
                i--;
            }
        }
    }

    public void receivesBadge() {
        this.numberOfBadges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getNumberOfBadges(), this.getPokemons().size());
    }
}
