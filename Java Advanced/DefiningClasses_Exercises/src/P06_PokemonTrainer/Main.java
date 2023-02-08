package P06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] inputArr = input.split("\\s+");
            String trainerName = inputArr[0];
            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);

            if(trainers.containsKey(trainerName)) {
                Pokemon currPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                Trainer currTrainer = trainers.get(trainerName);
                if(!currTrainer.getPokemons().contains(currPokemon)) {
                    currTrainer.getPokemons().add(currPokemon);
                }
            } else {
                Pokemon currPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                Trainer currTrainer = new Trainer(trainerName, 0, new ArrayList<>());
                currTrainer.getPokemons().add(currPokemon);
                trainers.put(trainerName, currTrainer);
            }
            input = scanner.nextLine();
        }

        String wantedElement = scanner.nextLine();
        while (!wantedElement.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                Trainer trainer = entry.getValue();
                if(trainer.hasPokemonWithElement(wantedElement)) {
                    trainer.receivesBadge();
                } else {
                    trainer.allPokemonsLoseHealth();
                }
            }
            wantedElement = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getNumberOfBadges(), e1.getValue().getNumberOfBadges()))
                .forEach(tr -> System.out.println(tr.getValue().toString()));
    }
}
