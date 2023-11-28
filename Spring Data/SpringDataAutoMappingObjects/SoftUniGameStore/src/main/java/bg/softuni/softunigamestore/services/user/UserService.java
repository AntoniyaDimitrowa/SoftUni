package bg.softuni.softunigamestore.services.user;

public interface UserService {
    String register(String[] arguments);
    String login(String[] arguments);
    String logout();
    boolean isLoggedUserAdmin();
}
