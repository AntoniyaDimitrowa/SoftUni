package bg.softuni.accountsystem.services;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal money, long id);
    void depositMoney(BigDecimal money, long id);
}
