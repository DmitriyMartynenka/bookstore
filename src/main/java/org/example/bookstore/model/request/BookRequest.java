package org.example.bookstore.model.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private Double price;
}
