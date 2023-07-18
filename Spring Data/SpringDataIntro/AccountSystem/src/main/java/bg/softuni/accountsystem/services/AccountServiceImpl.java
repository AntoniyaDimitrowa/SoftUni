package bg.softuni.accountsystem.services;

import bg.softuni.accountsystem.models.Account;
import bg.softuni.accountsystem.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, long id) {
        Optional<Account> accountOpt = accountRepository.findById(id);

        if(accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account is missing");
        }

        Account account = accountOpt.get();
        BigDecimal newBalance = account.getBalance().subtract(money);

        if(BigDecimal.ZERO.compareTo(newBalance) < 0) {
            throw new IllegalArgumentException("No enough money");
        }

        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    @Override
    public void depositMoney(BigDecimal money, long id) {
        Optional<Account> accountOpt = accountRepository.findById(id);

        if(accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account is missing");
        }

        Account account = accountOpt.get();

        if(BigDecimal.ZERO.compareTo(money) < 0) {
            throw new IllegalArgumentException("Cannot deposit negative money");
        }

        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }
}
