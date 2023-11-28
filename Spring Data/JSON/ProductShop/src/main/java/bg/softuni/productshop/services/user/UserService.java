package bg.softuni.productshop.services.user;

import bg.softuni.productshop.domain.entities.User;

import java.util.List;

public interface UserService {
    Long getCount();

    void saveAll(List<User> users);

    User getRandomUser();
}
