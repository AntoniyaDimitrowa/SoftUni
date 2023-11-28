package bg.softuni.softunigamestore.repositories;

import bg.softuni.softunigamestore.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findFirstByTitle(String title);
}
