package com.pg.obv.services;

import com.pg.obv.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
@Service
public interface ProjServices {

    List<Book> getBooks();

    Book getSingleBookById(int id);

    Book postBooks(Book b);

    void DeleteBook(int id);

    void updateBook(Book book, int id);

}
