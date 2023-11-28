package bg.softuni.softunigamestore;

import bg.softuni.softunigamestore.services.game.GameService;
import bg.softuni.softunigamestore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.softunigamestore.constance.Commands.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        String input = SCANNER.nextLine();
        while (!input.equals(CLOSE)) {
            final String[] arguments = input.split("\\|");
            final String command = arguments[0];

            final String output =
                    switch (command) {
                        case REGISTER_USER -> this.userService.register(arguments);
                        case LOGIN_USER -> this.userService.login(arguments);
                        case LOGOUT_USER -> this.userService.logout();
                        case ADD_GAME -> this.gameService.add(arguments);
                        case EDIT_GAME -> this.gameService.edit(arguments);
                        case DELETE_GAME -> this.gameService.delete(arguments);
                        default -> "No command found";
                    };

            System.out.println(output);
            input = SCANNER.nextLine();
        }
    }
}
