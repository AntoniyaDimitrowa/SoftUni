package bg.softuni.productshop.services.product;

import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long getCount() {
        return this.productRepository.count();
    }

    @Override
    public void saveAll(List<Product> products) {
        this.productRepository.saveAll(products);
    }
}
