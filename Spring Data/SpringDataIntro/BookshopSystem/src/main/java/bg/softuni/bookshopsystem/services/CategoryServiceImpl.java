package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.domain.entities.Category;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        this.categoryRepository.saveAllAndFlush(categories);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            categories.add(getRandomCategory());
        }

        return categories;
    }

    private Category getRandomCategory() {
        final int count = (int) this.categoryRepository.count();

        if (count != 0) {
            Integer randomId = new Random().nextInt(1, count) + 1;
            return this.categoryRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }
}
