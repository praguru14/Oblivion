package com.pg.obv.services;

import com.pg.obv.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class ProjServicesImpl implements ProjServices {

    private static List<Book> bookData = new ArrayList<>();

    static {
        bookData.add(new Book(123,"PG",450,"Prafull"));
        bookData.add(new Book(456,"PrafG",1450,"PrafullG"));
    }

    @Override
    public List<Book>  getBooks() {
        return bookData;
    }

    public Book getSingleBookById(int id){
    Book ID = bookData.stream().filter(e -> e.getId()==id).findFirst().get();
    return ID;
    }

    public Book postBooks(Book b){
       bookData.add(b);
        return b;
    }
    public Book DeleteBook(int id){
    Book deletedBook = bookData.stream().filter(e ->e.getId()!=id).findFirst().get();
    return deletedBook;
    }

    @Override
    public void updateBook(Book book, int id) {
       bookData=  bookData.stream().map(b->{
                if(b.getId()==id){
                    b.setValue(book.getValue());
                }
                return b;
                }).collect(Collectors.toList());

    }
}
