package org.example.bookstore.service;

import org.example.bookstore.model.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);

    List<Book> getAllBooks();

    void addBook(Book book);

    List<Book> getBooksByAuthor(String name);
}
