package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final Scanner scanner;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        //lesson 12
        //filling the database
//        this.seedService.seedAllData();
//
//        //1
//        this.bookService.getAllBooksAfterYear(LocalDate.of(2000, 1, 1))
//                .forEach(b -> System.out.println(b.getTitle()));
//
//        //2
//        this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1990, 1, 1))
//                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
//
//        //3
//        this.authorService.getAllAuthorsOrderedByTheirBookCountDesc()
//                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName() + " - " + a.getBooks().size()));
//
//        //4
//        this.bookService.getAllBooksByAuthorFirstAndLastName("George", "Powell");

        //lesson 14
        //1
        printBookTitlesByAgeRestriction();

        //2
        printGoldenEditionBookTitlesWithLessThan5000Copies();

        //3
        printBookTitlesAndPricesByPriceLowerThanAndHigherThan();

        //4
        printAllBookTitlesThatAreNotReleasedInAGivenYear();

        //5
        printAllBookTitlesEditionTypeAndPriceReleasedBeforeGivenDate();

        //6
        printAllAuthorsNamesWhichEndsWithAGivenString();

        //7
        printAllBookTitlesContainingAGivenString();

        //8
        printAllBookTitlesWithAuthorLastNameStartingWithGivenString();

        //9
        printTheCountOfAllBooksWhichTitleIsLongerThanGivenNumber();

        //10
        printAllAuthorsAntTheirTotalCopiesCount();

        //11
        printBookInformationByTitle();

        //12
        this.bookService.increaseCopiesForBookReleasedAfter(100, LocalDate.of(2005, 10, 12));

        //13
        this.bookService.deleteAllByCopiesLessThan(10000);

        //14
        System.out.println(this.bookService.getBooksCountByAuthorFirstNameAndAuthorLastName("Amanda Rice"));
    }

    private void printBookInformationByTitle() {
        String title = scanner.nextLine();
        this.bookService.getAllBooksByTitle(title).forEach(System.out::println);
    }

    private void printAllAuthorsAntTheirTotalCopiesCount() {
        int copies = this.bookService.getAllBooksByAuthor("Randy", "Graham")
                .stream()
                .mapToInt(Book::getCopies)
                .sum();
        System.out.println("Randy Graham - " + copies);
    }

    private void printTheCountOfAllBooksWhichTitleIsLongerThanGivenNumber() {
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.getCountOfAllBooksWhichTitleIsLongerThan(number));
    }

    private void printAllBookTitlesWithAuthorLastNameStartingWithGivenString() {
        String string = scanner.nextLine();
        this.bookService.getAllBooksWithAuthorLastNameStartingWith(string)
                .forEach(b -> System.out.println(b.getTitle() +
                        " (" + b.getAuthor().getFirstName() +
                        " " + b.getAuthor().getLastName() + ")"));
    }

    private void printAllBookTitlesContainingAGivenString() {
        String string = scanner.nextLine();
        this.bookService.getAllBooksWithTitleContainingString(string)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void printAllAuthorsNamesWhichEndsWithAGivenString() {
        String string = scanner.nextLine();
        this.authorService.getAllAuthorsWithNameEndingWith(string)
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void printAllBookTitlesEditionTypeAndPriceReleasedBeforeGivenDate() {
        String[] dateParts = scanner.nextLine().split("-");
        int year = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[0]);
        LocalDate date = LocalDate.of(year, month, day);

        this.bookService.getAllBooksBeforeDate(date)
                .forEach(b -> System.out.println(b.getTitle() +
                        " " + b.getEditionType() +
                        " " + b.getPrice()));
    }

    private void printAllBookTitlesThatAreNotReleasedInAGivenYear() {
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate firstDate = LocalDate.of(year, 1, 1);
        LocalDate secondDate = LocalDate.of(year, 12, 31);

        this.bookService.getAllBooksThatAreNotReleasedInAGivenYear(firstDate, secondDate)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void printBookTitlesAndPricesByPriceLowerThanAndHigherThan() {
        int firstNum = Integer.parseInt(this.scanner.nextLine());
        int secondNum = Integer.parseInt(this.scanner.nextLine());

        this.bookService.getAllBooksByPriceLowerThanAndPriceHigherThan(BigDecimal.valueOf(firstNum), BigDecimal.valueOf(secondNum))
                .forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));
    }

    private void printGoldenEditionBookTitlesWithLessThan5000Copies() {
        EditionType editionType = EditionType.valueOf("GOLD");
        this.bookService.getAllBooksByEditionTypeAndCopiesLessThan(editionType, 5000)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void printBookTitlesByAgeRestriction() {
        String ageRestrictionInput = this.scanner.nextLine().toUpperCase();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionInput);

        this.bookService.getAllBooksByAgeRestriction(ageRestriction)
                .forEach(b -> System.out.println(b.getTitle()));
    }
}
