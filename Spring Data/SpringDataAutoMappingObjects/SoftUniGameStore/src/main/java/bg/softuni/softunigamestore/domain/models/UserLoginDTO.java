package bg.softuni.softunigamestore.domain.models;

import lombok.Getter;
import lombok.Setter;

import static bg.softuni.softunigamestore.constance.ErrorMessages.INCORRECT_USERNAME_PASSWORD;

@Getter
@Setter
public class UserLoginDTO {
    private String email;
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void validate(String realPassword) {
        if (this.password.equals(realPassword)) {
            throw new IllegalArgumentException(INCORRECT_USERNAME_PASSWORD);
        }
    }

    public String successfullyLogged(String fullName) {
        return "Successfully logged in " + fullName;
    }
}
