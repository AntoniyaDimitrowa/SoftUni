package bg.softuni.shampoosapplication.repositories;

import bg.softuni.shampoosapplication.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
}
