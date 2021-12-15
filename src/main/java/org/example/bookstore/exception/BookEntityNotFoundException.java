package org.example.bookstore.exception;

public class BookEntityNotFoundException extends RuntimeException {
    public BookEntityNotFoundException(String message) {
        super(message);
    }
}
