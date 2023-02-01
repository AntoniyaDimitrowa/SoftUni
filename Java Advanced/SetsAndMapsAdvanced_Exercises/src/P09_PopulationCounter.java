import java.util.*;

public class P09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Long> countriesPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Map<String, Long>> countriesCities = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("report")) {
            String[] commandArr = command.split("\\|");
            String city = commandArr[0];
            String country = commandArr[1];
            long populationCity = Integer.parseInt(commandArr[2]);
            if(countriesPopulation.containsKey(country)) {
                long currPopulation = countriesPopulation.get(country);
                currPopulation += populationCity;
                countriesPopulation.put(country, currPopulation);

                Map<String, Long> currCities = countriesCities.get(country);
                currCities.put(city, populationCity);
                countriesCities.put(country, currCities);
            } else {
                countriesPopulation.put(country, populationCity);

                LinkedHashMap<String, Long> currCities = new LinkedHashMap<>();
                currCities.put(city, populationCity);
                countriesCities.put(country, currCities);
            }
            command = scanner.nextLine();
        }

        countriesCities.entrySet().stream()
                .sorted((e1, e2) -> countriesPopulation.get(e2.getKey()).compareTo(countriesPopulation.get(e1.getKey())))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), countriesPopulation.get(e.getKey()));
                    e.getValue().entrySet().stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(x -> System.out.printf("=>%s: %d%n", x.getKey(), x.getValue()));
                });
    }
}
