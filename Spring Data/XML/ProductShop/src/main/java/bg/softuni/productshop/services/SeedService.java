package bg.softuni.productshop.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {
    void seedUsers() throws IOException;
    void seedProducts() throws IOException;
    void seedCategories() throws IOException;
    default void seedAll() throws IOException {
        seedCategories();
        seedUsers();
        seedProducts();
    }
}
