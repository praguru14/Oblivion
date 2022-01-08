package com.pg.obv.services;

import com.pg.obv.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ProjServicesImpl implements ProjServices {

    private static List<Book> bookData = new ArrayList<>();

    static {
        bookData.add(new Book("123","PG",450,"Prafull"));
    }

    @Override
    public List<Book>  getBooks() {
        return bookData;
    }


}
