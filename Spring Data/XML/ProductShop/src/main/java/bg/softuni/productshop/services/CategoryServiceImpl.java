package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.models.category.CategorySummaryDTO;
import bg.softuni.productshop.domain.models.category.wrappers.CategorySummaryWrapperDTO;
import bg.softuni.productshop.repositories.CategoryRepository;
import bg.softuni.productshop.services.CategoryService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.productshop.constants.Paths.THIRD_XML_PATH;
import static bg.softuni.productshop.constants.Utils.writeIntoXmlFile;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
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

    @Override
    public List<CategorySummaryDTO> getCategorySummary() throws IOException, JAXBException {
        final List<CategorySummaryDTO> categorySummaries = this.categoryRepository.getCategorySummary();

        final CategorySummaryWrapperDTO wrapper = new CategorySummaryWrapperDTO(categorySummaries);

        writeIntoXmlFile(wrapper, THIRD_XML_PATH);

        return categorySummaries;
    }
}
