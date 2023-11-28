package bg.softuni.softunigamestore.services.user;

import bg.softuni.softunigamestore.domain.entities.User;
import bg.softuni.softunigamestore.domain.models.UserLoginDTO;
import bg.softuni.softunigamestore.domain.models.UserRegisterDTO;
import bg.softuni.softunigamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static bg.softuni.softunigamestore.constance.ErrorMessages.EMAIL_ALREADY_EXISTS;
import static bg.softuni.softunigamestore.constance.ErrorMessages.INCORRECT_USERNAME_PASSWORD;

@Service
public class UserServiceImpl implements UserService {
    private User loggedInUser;

    final private UserRepository userRepository;
    final private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public String register(String[] arguments) {
        final int argsLength = arguments.length;
        final String email = argsLength > 1 ? arguments[1] : "";
        final String password = argsLength > 2 ? arguments[2] : "";
        final String confirmPassword = argsLength > 3 ? arguments[3] : "";
        final String fullName = argsLength > 4 ? arguments[4] : "";

        UserRegisterDTO userRegisterDTO;

        try {
            userRegisterDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        Optional<User> optional = this.userRepository.findFirstByEmail(email);

        if(optional.isPresent()) {
            return EMAIL_ALREADY_EXISTS;
        }

        final User user = this.modelMapper.map(userRegisterDTO, User.class);

        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        } else {
            user.setAdmin(false);
        }

        this.userRepository.saveAndFlush(user);

        return userRegisterDTO.userSuccessfullyRegistered();
    }

    @Override
    public String login(String[] arguments) {
        final int argsLength = arguments.length;
        final String email = argsLength > 1 ? arguments[1] : "";
        final String password = argsLength > 2 ? arguments[2] : "";

        Optional<User> optional = this.userRepository.findFirstByEmail(email);

        if (optional.isEmpty()) {
            return INCORRECT_USERNAME_PASSWORD;
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO(email, password);
        this.modelMapper.map(userLoginDTO, User.class);

        try {
            userLoginDTO.validate(optional.get().getPassword());
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        this.loggedInUser = optional.get();
        return userLoginDTO.successfullyLogged(this.loggedInUser.getFullName());
    }

    @Override
    public String logout() {
        if (this.loggedInUser == null) return "No user logged";

        this.loggedInUser = null;

        return "test me logout";    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.loggedInUser != null && this.loggedInUser.isAdmin();
    }
}
