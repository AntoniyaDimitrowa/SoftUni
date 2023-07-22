package bg.softuni.shampoosapplication.repositories;

import bg.softuni.shampoosapplication.entities.Shampoo;
import bg.softuni.shampoosapplication.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<Object> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query("SELECT s " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :ingredientNames")
    List<Shampoo> findAllByIngredientsNameIn(List<String> ingredientName);

    //TODO
//    @Query()
//    List<Shampoo> findAllByIngredientsCount(int ingredientsCount);
}
