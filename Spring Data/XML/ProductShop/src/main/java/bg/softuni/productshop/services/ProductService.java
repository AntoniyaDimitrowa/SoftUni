package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.models.product.ProductBasicInfoWithSellerFullNameDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Long getCount();

    void saveAll(List<Product> products);
    List<ProductBasicInfoWithSellerFullNameDTO> getProductsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException, JAXBException;

}
