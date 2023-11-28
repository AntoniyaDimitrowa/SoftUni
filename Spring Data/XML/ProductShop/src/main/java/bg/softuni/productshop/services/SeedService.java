package bg.softuni.productshop.services;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface SeedService {
    void seedUsers() throws IOException;
    void seedProducts() throws IOException, JAXBException;
    void seedCategories() throws IOException, JAXBException;
    default void seedAll() throws IOException {
        seedCategories();
        seedUsers();
        seedProducts();
    }
}
