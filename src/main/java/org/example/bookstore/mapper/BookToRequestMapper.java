package org.example.bookstore.mapper;

import org.example.bookstore.model.Book;
import org.example.bookstore.model.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToRequestMapper {
    Book addBookRequestToBook(BookRequest bookRequest);
}
