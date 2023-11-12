package bg.softuni.productshop.services.product;

import bg.softuni.productshop.domain.entities.Product;

import java.util.List;

public interface ProductService {
    Long getCount();

    void saveAll(List<Product> products);
}
