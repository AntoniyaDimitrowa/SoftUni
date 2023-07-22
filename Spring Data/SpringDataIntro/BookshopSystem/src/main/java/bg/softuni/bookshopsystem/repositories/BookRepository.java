package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);
    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal firstNum, BigDecimal secondNum);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate firstDate, LocalDate secondDate);

    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllByAuthorLastNameStartingWith(String string);
}
