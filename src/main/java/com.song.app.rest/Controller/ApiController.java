package com.song.app.rest.Controller;

import com.song.app.rest.Models.Author;
import com.song.app.rest.Models.Book;
import com.song.app.rest.Repo.BookRepo;
import com.song.app.rest.dto.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping(value="/allBooks")
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(value="/book")
    public List<Book> getBook(@RequestParam String name, @RequestParam String birthday,
                              @RequestParam String title) {

        return bookRepo.findByAuthorsOrTitle(name, birthday, title);
    }

    @PostMapping(value="/add")
    public String saveBook(@RequestBody BookRequest request) {
        bookRepo.save(request.getBook());
        return "Book added!";
    }

    @PutMapping(value="/update/{isbn}")
    public String updateBook(@PathVariable long isbn, @RequestBody BookRequest request) {
        Book updatedBook = bookRepo.findById(isbn).get();

        updatedBook.setTitle(request.getBook().getTitle());
        updatedBook.setYear(request.getBook().getYear());
        updatedBook.setPrice(request.getBook().getPrice());
        updatedBook.setGenre(request.getBook().getGenre());
        updatedBook.setAuthors(request.getBook().getAuthors());
        bookRepo.save(updatedBook);
        return "Book updated!";
    }

    @DeleteMapping(value="/delete/{isbn}")
    public String deleteBook(@PathVariable long isbn) {
        Book deleteBook = bookRepo.findById(isbn).get();
        bookRepo.delete(deleteBook);
        return "Book deleted with the isbn: " + isbn;
    }
}
