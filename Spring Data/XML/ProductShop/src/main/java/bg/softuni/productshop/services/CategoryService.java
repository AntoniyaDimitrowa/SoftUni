package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.models.category.CategorySummaryDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    Long getCount();

    void saveAll(List<Category> categories);

    Category getRandomCategory();
    List<CategorySummaryDTO> getCategorySummary() throws IOException, JAXBException;

}
