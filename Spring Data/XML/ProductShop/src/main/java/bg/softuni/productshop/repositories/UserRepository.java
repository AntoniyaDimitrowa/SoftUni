package bg.softuni.productshop.repositories;

import bg.softuni.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from `product_shop`.users order by RAND() LIMIT 1", nativeQuery = true)
    Optional<User> getRandomEntity();

    List<User> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName();
}
