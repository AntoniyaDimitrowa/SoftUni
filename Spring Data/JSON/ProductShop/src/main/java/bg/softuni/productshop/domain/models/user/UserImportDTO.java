package bg.softuni.productshop.domain.models.user;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserImportDTO {
    private String firstName;
    private String lastName;
    private Integer age;
}
