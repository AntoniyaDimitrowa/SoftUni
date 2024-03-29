package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    boolean isDataSeeded();

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date);
    List<Author> getAllAuthorsOrderedByTheirBookCountDesc();

    List<Author> getAllAuthorsWithNameEndingWith(String string);
}
