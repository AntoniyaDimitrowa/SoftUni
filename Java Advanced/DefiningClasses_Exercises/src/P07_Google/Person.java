package P07_Google;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parent> parents;
    private List<Child> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Person(String name, Company company, Car car, List<Pokemon> pokemonList, List<Parent> parents, List<Child> children) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.pokemonList = pokemonList;
        this.parents = parents;
        this.children = children;
    }

    public void addPokemon(Pokemon pokemon) {
        this.getPokemonList().add(pokemon);
    }

    public void addParent(Parent parent) {
        this.getParents().add(parent);
    }

    public void addChild(Child child) {
        this.getChildren().add(child);
    }

    public void print() {
        System.out.println(this.name);
        System.out.println("Company: ");
        if(this.company != null) {
            System.out.println(this.company.toString());
        }

        System.out.println("Car: ");
        if(this.car != null) {
            System.out.println(this.car.toString());
        }

        System.out.println("Pokemon: ");
        if(this.pokemonList != null) {
            for (Pokemon pokemon : this.pokemonList) {
                System.out.println(pokemon.toString());
            }
        }

        System.out.println("Parents: ");
        if(this.parents != null) {
            for (Parent parent : this.parents) {
                System.out.println(parent.toString());
            }
        }

        System.out.println("Children: ");
        if(this.children != null) {
            for (Child child : this.children) {
                System.out.println(child.toString());
            }
        }
    }
}
