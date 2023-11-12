package bg.softuni.productshop.domain.models.product;

import bg.softuni.productshop.domain.entities.Product;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBasicInfoWithSellerFullNameDTO {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    @SerializedName(value = "seller")
    @XmlAttribute(name = "seller")
    private String sellerFirstName;


    public static ProductBasicInfoWithSellerFullNameDTO getFromProduct(Product product) {
        String fullName = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();

        return new ProductBasicInfoWithSellerFullNameDTO(product.getName(), product.getPrice(), fullName);
    }
}
