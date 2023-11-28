package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.domain.models.category.wrappers.CategoryWrapperImportDTO;
import bg.softuni.productshop.domain.models.product.wrappers.ProductWrapperImportDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bg.softuni.productshop.constants.Paths.*;
import static bg.softuni.productshop.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    public SeedServiceImpl(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedUsers() throws IOException {
        //TODO
    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        if(this.productService.getCount() > 0) return;

        final FileReader fileReader = new FileReader(PRODUCTS_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ProductWrapperImportDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ProductWrapperImportDTO wrapperImportModel = (ProductWrapperImportDTO) unmarshaller.unmarshal(fileReader);


        final List<Product> products = wrapperImportModel.getProducts()
                .stream()
                .map(model -> MODEL_MAPPER.map(model, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .collect(Collectors.toList());

        this.productService.saveAll(products);
        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        if(this.categoryService.getCount() > 0) return;

        final FileReader fileReader = new FileReader(CATEGORIES_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CategoryWrapperImportDTO.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final CategoryWrapperImportDTO wrapperImportModel = (CategoryWrapperImportDTO) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        List<Category> categories = wrapperImportModel.getCategories()
                .stream()
                .map(categoryImportModel -> MODEL_MAPPER.map(categoryImportModel, Category.class))
                .toList();

        this.categoryService.saveAll(categories);
        fileReader.close();
    }

    private Product setRandomCategories(Product product) {
        final Random random = new Random();
        int categoriesCount = random.nextInt(this.categoryService.getCount().intValue());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, categoriesCount)
                .forEach(value -> {
                    categories.add(this.categoryService.getRandomCategory());
                });

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        final Random random = new Random();
        int randomInt = random.nextInt(10);
        if(randomInt < 5) {
            final User randomUser = this.userService.getRandomUser();

            product.setBuyer(randomUser);
        }
        return product;
    }

    private Product setRandomSeller(Product product) {
        User randomUser = this.userService.getRandomUser();

        while(product.getBuyer() != null && product.getBuyer().getId() == randomUser.getId()) {
            randomUser = this.userService.getRandomUser();
        }

        product.setSeller(randomUser);

        return product;
    }
}
