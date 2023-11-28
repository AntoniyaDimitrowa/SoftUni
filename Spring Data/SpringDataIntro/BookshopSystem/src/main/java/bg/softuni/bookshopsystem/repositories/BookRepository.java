package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import bg.softuni.bookshopsystem.domain.models.BookPrintInformation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    @Query("Select count(b) from Book b where length(b.title) > :number")
    int countAllByTitleLengthGreaterThan(int number);

    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    @Query("Select new bg.softuni.bookshopsystem.domain.models.BookPrintInformation(b.title, b.editionType, b.ageRestriction, b.price) " +
            "from Book b " +
            "where b.title = :title")
    List<BookPrintInformation> findAllByTitle(String title);

    @Modifying
    @Transactional
    @Query("update Book b set b.copies = b.copies + :copiesAdded where b.releaseDate > :date")
    int updateBooksCopies(Integer copiesAdded, LocalDate date);

    @Transactional
    int deleteAllByCopiesLessThan(Integer copies);

    @Procedure(value = "usp_get_book_written_by")
    int getBooksCountByAuthorFirstNameAndAuthorLastName(String fullName);
}
