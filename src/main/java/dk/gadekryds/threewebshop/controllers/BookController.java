package dk.gadekryds.threewebshop.controllers;

import dk.gadekryds.threewebshop.domain.data.BookRepository;
import dk.gadekryds.threewebshop.domain.entities.Book;
import dk.gadekryds.threewebshop.domain.entities.Bookpage;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody Bookpage bookpage) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty())
            return;

        Book book = optionalBook.get();

        book.getBookpages().add(bookpage);
        bookRepository.save(book);

    }
}
