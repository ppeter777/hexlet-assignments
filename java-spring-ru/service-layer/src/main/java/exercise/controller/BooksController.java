package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping(path = "")
    public List<BookDTO> index() {
        var books = bookService.getAll();
        return books;
    }

    @GetMapping(path = "/{id}")
    public BookDTO show(@PathVariable long id) {
        var book = bookService.findById(id);
        return book;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookCreateDTO bookData) {
        var book = bookService.create(bookData);
        return book;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@RequestBody BookUpdateDTO bookData, @PathVariable long id) {
        var book = bookService.update(bookData, id);
        return book;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }
    // END
}
