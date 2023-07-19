package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);
    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
