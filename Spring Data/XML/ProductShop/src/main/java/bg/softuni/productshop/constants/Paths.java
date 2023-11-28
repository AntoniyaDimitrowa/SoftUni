package bg.softuni.productshop.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path CATEGORIES_PATH =
            Path.of("src", "main", "resources", "dbContent", "categories.xml");

    public static final Path USERS_PATH =
            Path.of("src", "main", "resources", "dbContent", "users.xml");

    public static final Path PRODUCTS_PATH =
            Path.of("src", "main", "resources", "dbContent", "products.xml");

    public static final Path FIRST_XML_PATH =
            Path.of("src", "main", "resources", "output", "xml", "1.xml");

    public static final Path SECOND_XML_PATH =
            Path.of("src", "main", "resources", "output", "xml", "2.xml");

    public static final Path THIRD_XML_PATH =
            Path.of("src", "main", "resources", "output", "xml", "3.xml");

    public static final Path FOURTH_XML_PATH =
            Path.of("src", "main", "resources", "output", "xml", "4.xml");
}
