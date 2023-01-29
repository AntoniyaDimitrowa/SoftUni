import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            if(continents.containsKey(continent)) {
                Map<String, List<String>> countries = continents.get(continent);
                if(countries.containsKey(country)) {
                    continents.get(continent).get(country).add(city);
                } else {
                    List<String> cities = new ArrayList<>();
                    cities.add(city);
                    continents.get(continent).put(country, cities);
                }
            } else {
                Map<String, List<String>> countries = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countries.put(country, cities);
                continents.put(continent, countries);
            }
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : continents.entrySet()) {
            String continent = entry.getKey();
            System.out.println(continent + ":");
            Map<String, List<String>> countries = entry.getValue();
            for (Map.Entry<String, List<String>> entry2 : countries.entrySet()) {
                String country = entry2.getKey();
                System.out.print("  " + country + " -> ");
                List<String> cities = entry2.getValue();
                for (int i = 0; i < cities.size(); i++) {
                    if(i == (cities.size() - 1)) {
                        System.out.println(cities.get(i));
                    } else {
                        System.out.print(cities.get(i) + ", ");
                    }
                }
            }
        }
    }
}
