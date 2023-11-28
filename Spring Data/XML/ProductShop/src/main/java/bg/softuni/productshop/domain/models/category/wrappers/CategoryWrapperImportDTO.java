package bg.softuni.productshop.domain.models.category.wrappers;

import bg.softuni.productshop.domain.models.category.CategoryImportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWrapperImportDTO {

    @XmlElement(name = "category")
    private List<CategoryImportDTO> categories;

}
