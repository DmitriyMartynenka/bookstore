package org.example.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.BookEntity;
import org.example.bookstore.dao.BookRepository;
import org.example.bookstore.exception.BookEntityNotFoundException;
import org.example.bookstore.mapper.BookToEntityMapper;
import org.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookEntityNotFoundException("Book not found " + id));
        return mapper.BookEntityToBook(bookEntity);

    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> allBooks = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : allBooks) {
            books.add(mapper.BookEntityToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(mapper.BookToBookEntity(book));
    }

    @Override
    public List<Book> getBooksByAuthor(String name) {
        Iterable<BookEntity> authorBooks = bookRepository.findAllByAuthorContaining(name);
        List<Book> books = new ArrayList<>();
        for(BookEntity bookEntity : authorBooks) {
            books.add(mapper.BookEntityToBook(bookEntity));
        }
        return books;
    }

}
