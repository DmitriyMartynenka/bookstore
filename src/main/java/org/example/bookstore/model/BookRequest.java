package org.example.bookstore.model;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private Double price;
}
