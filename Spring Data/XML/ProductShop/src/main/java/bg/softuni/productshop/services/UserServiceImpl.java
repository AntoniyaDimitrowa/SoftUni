package bg.softuni.productshop.services;

import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.repositories.UserRepository;
import bg.softuni.productshop.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long getCount() {
        return this.userRepository.count();
    }

    @Override
    public void saveAll(List<User> users) {
        this.userRepository.saveAll(users);
    }

    @Override
    public User getRandomUser() {
        return this.userRepository.getRandomEntity()
                .orElseThrow(NoSuchElementException::new);
    }
}
