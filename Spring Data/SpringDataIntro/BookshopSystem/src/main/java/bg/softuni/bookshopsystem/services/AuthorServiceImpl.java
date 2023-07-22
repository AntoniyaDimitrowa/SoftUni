package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.domain.entities.Author;
import bg.softuni.bookshopsystem.domain.entities.Book;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        final long count = this.authorRepository.count();

        if (count != 0) {
            long randomId = new Random().nextLong(1L, count) + 1L;
            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }

    @Override
    public List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date) {
        return this.bookService.getAllBooksBeforeDate(date)
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> getAllAuthorsOrderedByTheirBookCountDesc() {
        return this.authorRepository.findAllDistinctOrderByBooks();
    }

    @Override
    public List<Author> getAllAuthorsWithNameEndingWith(String string) {
        return this.authorRepository.findAllByFirstNameEndingWith(string);
    }


}
