package bg.softuni.shampoosapplication.repositories;

import bg.softuni.shampoosapplication.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String letters);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient AS i SET i.price = i.price * 1.1")
    void increasePriceBy10Percent();

    @Transactional
    void deleteIngredientsByName(String name);
}
