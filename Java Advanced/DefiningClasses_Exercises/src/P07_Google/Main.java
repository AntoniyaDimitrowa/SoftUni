package P07_Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputArr = input.split("\\s+");
            String personName = inputArr[0];
            String infoType = inputArr[1];
            switch (infoType) {
                case "company":
                    String companyName = inputArr[2];
                    String department = inputArr[3];
                    double salary = Double.parseDouble(inputArr[4]);
                    Company company = new Company(companyName, department, salary);
                    if(people.containsKey(personName)) {
                        people.get(personName).setCompany(company);
                    } else {
                        Person person = new Person(personName, company, null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                        people.put(personName, person);
                    }
                    break;
                case "pokemon":
                    String pokemonName = inputArr[2];
                    String pokemonType = inputArr[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    if(people.containsKey(personName)) {
                        people.get(personName).addPokemon(pokemon);
                    } else {
                        List<Pokemon> pokemons = new ArrayList<>();
                        pokemons.add(pokemon);
                        Person person = new Person(personName, null, null, pokemons, new ArrayList<>(), new ArrayList<>());
                        people.put(personName, person);
                    }
                    break;
                case "parents":
                    String parentName = inputArr[2];
                    String parentBirthday = inputArr[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    if(people.containsKey(personName)) {
                        people.get(personName).addParent(parent);
                    } else {
                        List<Parent> parents = new ArrayList<>();
                        parents.add(parent);
                        Person person = new Person(personName, null, null, new ArrayList<>(), parents, new ArrayList<>());
                        people.put(personName, person);
                    }
                    break;
                case "children":
                    String childName = inputArr[2];
                    String childBirthday = inputArr[3];
                    Child child = new Child(childName, childBirthday);
                    if(people.containsKey(personName)) {
                        people.get(personName).addChild(child);
                    } else {
                        List<Child> children = new ArrayList<>();
                        children.add(child);
                        Person person = new Person(personName, null, null, new ArrayList<>(), new ArrayList<>(), children);
                        people.put(personName, person);
                    }
                    break;
                case "car":
                    String carModel = inputArr[2];
                    int carSpeed = Integer.parseInt(inputArr[3]);
                    Car car = new Car(carModel, carSpeed);
                    if(people.containsKey(personName)) {
                        people.get(personName).setCar(car);
                    } else {
                        Person person = new Person(personName, null, car, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                        people.put(personName, person);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        String personName = scanner.nextLine();
        people.get(personName).print();
    }
}
