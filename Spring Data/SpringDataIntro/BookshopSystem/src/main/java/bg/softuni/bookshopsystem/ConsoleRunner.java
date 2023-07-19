package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        //filling the database
        this.seedService.seedAllData();

        //1
        this.bookService.getAllBooksAfterYear(LocalDate.of(2000, 1, 1))
                .forEach(b -> System.out.println(b.getTitle()));

        //2
        this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1990, 1, 1))
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));

        //3
        this.authorService.getAllAuthorsOrderedByTheirBookCountDesc()
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName() + " - " + a.getBooks().size()));

        //4
        this.bookService.getAllBooksByAuthorFirstAndLastName("George", "Powell");

    }
}
