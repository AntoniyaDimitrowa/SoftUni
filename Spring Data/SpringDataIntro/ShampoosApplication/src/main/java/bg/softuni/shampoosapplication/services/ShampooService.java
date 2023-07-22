package bg.softuni.shampoosapplication.services;

import bg.softuni.shampoosapplication.entities.Shampoo;
import bg.softuni.shampoosapplication.entities.Size;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllBySizeOrLabelId(Size size, long labelId);

    List<Object> findAllByPriceGreaterThan(BigDecimal price);

    int findCheaperThanCount(BigDecimal price);

    List<Shampoo> findAllWithIngredients(List<String> ingredientName);

    List<Shampoo> findAllWithIngredientsCount(int ingredientsCount);

}
