package bg.softuni.productshop.domain.models.product.wrappers;

import bg.softuni.productshop.domain.models.product.ProductImportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWrapperImportDTO {

    @XmlElement(name = "product")
    private List<ProductImportDTO> products;
}
