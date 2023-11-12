package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Category;
import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.domain.models.category.CategoryImportDTO;
import bg.softuni.productshop.domain.models.product.ProductImportDTO;
import bg.softuni.productshop.domain.models.user.UserImportDTO;
import bg.softuni.productshop.services.category.CategoryService;
import bg.softuni.productshop.services.product.ProductService;
import bg.softuni.productshop.services.user.UserService;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bg.softuni.productshop.constants.Paths.*;
import static bg.softuni.productshop.constants.Utils.GSON;
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
        if(this.userService.getCount() > 0) return;

        final FileReader fileReader = new FileReader(USERS_PATH.toFile());

        final List<User> users = Arrays.stream(GSON.fromJson(fileReader, UserImportDTO[].class))
                .map(userImportDTO -> MODEL_MAPPER.map(userImportDTO, User.class))
                .collect(Collectors.toList());

        this.userService.saveAll(users);
        fileReader.close();
    }

    @Override
    public void seedProducts() throws IOException {
        if(this.productService.getCount() > 0) return;

        final FileReader fileReader = new FileReader(PRODUCTS_PATH.toFile());

        final List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportDTO[].class))
                .map(productImportDTO -> MODEL_MAPPER.map(productImportDTO, Product.class))
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .collect(Collectors.toList());

        this.productService.saveAll(products);
        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryService.getCount() > 0) return;

        final FileReader fileReader = new FileReader(CATEGORIES_PATH.toFile());

        final List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportDTO[].class))
                .map(categoryImport -> MODEL_MAPPER.map(categoryImport, Category.class))
                .collect(Collectors.toList());

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
