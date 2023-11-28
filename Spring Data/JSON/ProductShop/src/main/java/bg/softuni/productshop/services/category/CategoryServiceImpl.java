package bg.softuni.productshop.services.category;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long getCount() {
        return this.categoryRepository.count();
    }

    @Override
    public void saveAll(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public Category getRandomCategory() {
        return this.categoryRepository.getRandomEntity()
                .orElseThrow(NoSuchElementException::new);
    }
}
