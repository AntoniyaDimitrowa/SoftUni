package bg.softuni.productshop.domain.models.product;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldWithCountDTO {

    @XmlAttribute
    private Integer count;

    @XmlElement(name = "product")
    private List<ProductBasicInfoDTO> products;

    public static ProductsSoldWithCountDTO productsSoldWithCountDto(List<ProductBasicInfoDTO> products) {
        return new ProductsSoldWithCountDTO(products.size(), products);
    }
}
