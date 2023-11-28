package bg.softuni.productshop.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path USERS_PATH =
            Path.of("src", "main", "resources", "dbContent", "users.json");

    public static final Path PRODUCTS_PATH =
            Path.of("src", "main", "resources", "dbContent", "products.json");
    public static final Path CATEGORIES_PATH =
            Path.of("src", "main", "resources", "dbContent", "categories.json");
}
