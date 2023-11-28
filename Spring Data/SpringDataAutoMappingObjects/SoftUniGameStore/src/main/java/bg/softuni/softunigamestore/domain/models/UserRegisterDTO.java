package bg.softuni.softunigamestore.domain.models;

import lombok.*;

import java.util.regex.Pattern;

import static bg.softuni.softunigamestore.constance.ErrorMessages.*;
import static bg.softuni.softunigamestore.constance.Validations.EMAIL_PATTERN;
import static bg.softuni.softunigamestore.constance.Validations.PASSWORD_PATTERN;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class UserRegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    private void validate() {
        if (!Pattern.matches(EMAIL_PATTERN, this.email)) {
            throw new IllegalArgumentException(INVALID_EMAIL);
        }

        if (!Pattern.matches(PASSWORD_PATTERN, this.password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }

        if (!this.password.equals(this.confirmPassword)) {
            throw new IllegalArgumentException(CONF_PASS_DOES_NOT_MATCH);
        }
    }

    public String userSuccessfullyRegistered() {
        return fullName + " was registered.";
    }
}
