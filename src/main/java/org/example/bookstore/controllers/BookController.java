package org.example.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.mapper.BookToRequestMapper;
import org.example.bookstore.model.Book;
import org.example.bookstore.model.BookRequest;
import org.example.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookToRequestMapper mapper;

    @GetMapping
    public List<Book> addAllBooks(@RequestParam(required = false) String name) {
        if(name!=null) {
            return bookService.getBooksByAuthor(name);
        }
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest bookRequest) {
        bookService.addBook(mapper.addBookRequestToBook(bookRequest));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return  bookService.getBookById(id);
    }
}
