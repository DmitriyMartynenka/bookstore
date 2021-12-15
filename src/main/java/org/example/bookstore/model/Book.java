package org.example.bookstore.model;

import lombok.Value;

@Value
public class Book {
    Long id;
    String title;
    String author;
    Double price;
}
