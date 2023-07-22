package bg.softuni.shampoosapplication.services;

import bg.softuni.shampoosapplication.entities.Ingredient;
import bg.softuni.shampoosapplication.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    final private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String letters) {
        return this.ingredientRepository.findAllByNameStartingWith(letters);
    }

    @Override
    public List<Ingredient> findAllByNameWithin(List<String> names) {
        return this.ingredientRepository.findAllByNameInOrderByPrice(names);
    }

    @Override
    public void increasePrice() {
        this.ingredientRepository.increasePriceBy10Percent();
    }
}
