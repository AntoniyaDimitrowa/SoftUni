package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import bg.softuni.bookshopsystem.domain.models.BookPrintInformation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterDate(LocalDate date);
    List<Book> getAllBooksBeforeDate(LocalDate date);
    List<Book> getAllBooksByAuthorFirstAndLastName(String first, String last);

    List<Book> getAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getAllBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> getAllBooksByPriceLowerThanAndPriceHigherThan(BigDecimal firstNum, BigDecimal secondNum);

    List<Book> getAllBooksThatAreNotReleasedInAGivenYear(LocalDate firstDate, LocalDate secondDate);

    List<Book> getAllBooksWithTitleContainingString(String string);

    List<Book> getAllBooksWithAuthorLastNameStartingWith(String string);

    int getCountOfAllBooksWhichTitleIsLongerThan(int number);

    List<Book> getAllBooksByAuthor(String firstName, String lastName);

    List<BookPrintInformation> getAllBooksByTitle(String title);

    void increaseCopiesForBookReleasedAfter(Integer addedCopies, LocalDate dateAfter);

    int deleteAllByCopiesLessThan(Integer copies);

    int getBooksCountByAuthorFirstNameAndAuthorLastName(String firstName);
}
