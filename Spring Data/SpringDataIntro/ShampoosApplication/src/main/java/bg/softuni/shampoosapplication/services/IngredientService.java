package bg.softuni.shampoosapplication.services;

import bg.softuni.shampoosapplication.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String letters);

    List<Ingredient> findAllByNameWithin(List<String> names);


    void increasePrice();
}
