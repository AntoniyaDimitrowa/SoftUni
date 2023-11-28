package bg.softuni.productshop.services.category;

import bg.softuni.productshop.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    Long getCount();

    void saveAll(List<Category> categories);

    Category getRandomCategory();

}
