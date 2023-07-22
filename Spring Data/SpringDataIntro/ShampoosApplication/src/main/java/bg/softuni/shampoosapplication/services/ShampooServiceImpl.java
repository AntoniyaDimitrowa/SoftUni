package bg.softuni.shampoosapplication.services;

import bg.softuni.shampoosapplication.entities.Shampoo;
import bg.softuni.shampoosapplication.entities.Size;
import bg.softuni.shampoosapplication.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    final private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelId(Size size, long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Object> findAllByPriceGreaterThan(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int findCheaperThanCount(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllWithIngredients(List<String> ingredientName) {
        return this.shampooRepository.findAllByIngredientsNameIn(ingredientName);
    }

    @Override
    public List<Shampoo> findAllWithIngredientsCount(int ingredientsCount) {
        return null;
        //return this.shampooRepository.findAllByIngredientsCount(ingredientsCount);
    }
}
