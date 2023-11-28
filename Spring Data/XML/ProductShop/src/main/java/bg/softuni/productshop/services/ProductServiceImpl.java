package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.Product;
import bg.softuni.productshop.domain.models.product.ProductBasicInfoWithSellerFullNameDTO;
import bg.softuni.productshop.domain.models.product.wrappers.ProductBasicInfoWrapperDTO;
import bg.softuni.productshop.repositories.ProductRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static bg.softuni.productshop.constants.Paths.FIRST_XML_PATH;
import static bg.softuni.productshop.constants.Utils.writeIntoXmlFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
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

    @Override
    public List<ProductBasicInfoWithSellerFullNameDTO> getProductsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException, JAXBException {
        final List<ProductBasicInfoWithSellerFullNameDTO> products =
                this.productRepository
                        .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                        .stream()
                        .map(ProductBasicInfoWithSellerFullNameDTO::getFromProduct)
                        .toList();

        final ProductBasicInfoWrapperDTO wrapper = new ProductBasicInfoWrapperDTO(products);

        writeIntoXmlFile(wrapper, FIRST_XML_PATH);

        return products;
    }
}
