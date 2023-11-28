package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import bg.softuni.bookshopsystem.domain.models.BookPrintInformation;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterDate(LocalDate date) {
        return bookRepository
                .findAllByReleaseDateAfter(date)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Book> getAllBooksBeforeDate(LocalDate date) {
        return bookRepository
                .findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> getAllBooksByAuthorFirstAndLastName(String first, String last) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(first, last);
    }

    @Override
    public List<Book> getAllBooksByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllBooksByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> getAllBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies) {
        return this.bookRepository.findAllBooksByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public List<Book> getAllBooksByPriceLowerThanAndPriceHigherThan(BigDecimal firstNum, BigDecimal secondNum) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(firstNum, secondNum);
    }

    @Override
    public List<Book> getAllBooksThatAreNotReleasedInAGivenYear(LocalDate firstDate, LocalDate secondDate) {
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(firstDate, secondDate);
    }

    @Override
    public List<Book> getAllBooksWithTitleContainingString(String string) {
        return this.bookRepository.findAllByTitleContaining(string);
    }

    @Override
    public List<Book> getAllBooksWithAuthorLastNameStartingWith(String string) {
        return this.bookRepository.findAllByAuthorLastNameStartingWith(string);
    }

    @Override
    public int getCountOfAllBooksWhichTitleIsLongerThan(int number) {
        return this.bookRepository.countAllByTitleLengthGreaterThan(number);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String firstName, String lastName) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastName(firstName, lastName);
    }

    @Override
    public List<BookPrintInformation> getAllBooksByTitle(String title) {
        return this.bookRepository.findAllByTitle(title);
    }

    @Override
    public void increaseCopiesForBookReleasedAfter(Integer addedCopies, LocalDate dateAfter) {
        final List<Book> books = this.bookRepository.findAllByReleaseDateAfter(dateAfter).get();

        books.forEach(book -> book.setCopies(book.getCopies() + addedCopies));

        this.bookRepository.saveAllAndFlush(books);

        System.out.println(addedCopies * books.size());
    }

    @Override
    public int deleteAllByCopiesLessThan(Integer copies) {
        return this.bookRepository.deleteAllByCopiesLessThan(copies);
    }

    @Override
    public int getBooksCountByAuthorFirstNameAndAuthorLastName(String firstName) {
        return this.bookRepository.getBooksCountByAuthorFirstNameAndAuthorLastName(firstName);
    }
}
