package org.example.bookstore.mapper;

import org.example.bookstore.dao.BookEntity;
import org.example.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity BookToBookEntity(Book book);
    Book BookEntityToBook(BookEntity bookEntity);
}
