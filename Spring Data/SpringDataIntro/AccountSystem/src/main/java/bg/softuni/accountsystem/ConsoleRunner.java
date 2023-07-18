package bg.softuni.accountsystem;

import bg.softuni.accountsystem.models.Account;
import bg.softuni.accountsystem.models.User;
import bg.softuni.accountsystem.services.AccountService;
import bg.softuni.accountsystem.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Gosho", 25);

        Account account = new Account(new BigDecimal("25000"));
        account.setUser(user);

        user.setAccounts(new ArrayList<>(){{
            add(account);
        }});

        userService.registerUser(user);

        accountService.withdrawMoney(new BigDecimal("20000"), account.getId());
        accountService.depositMoney(new BigDecimal("30000"), account.getId());
    }
}
