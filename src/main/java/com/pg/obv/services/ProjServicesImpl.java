package com.pg.obv.services;

import com.pg.obv.dao.BookRepository;
import com.pg.obv.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class ProjServicesImpl implements ProjServices {
    @Autowired
    BookRepository bookRepository;

//    private static List<Book> bookData = new ArrayList<>();
//
//    sta
//    tic {
//        bookData.add(new Book(123,"PG",450,"Prafull"));
//        bookData.add(new Book(456,"PrafG",1450,"PrafullG"));
//    }

    @Override
    public List<Book>  getBooks() {
      List<Book> list = (List<Book>) bookRepository.findAll();
        return  list;
    }

    public Book getSingleBookById(int id){
    //Book ID = bookData.stream().filter(e -> e.getId()==id).findFirst().get();
        Book ID  =  bookRepository.findById(id);
    return ID;
    }

    public Book postBooks(Book b){
       Book book = bookRepository.save(b);
        return book;
    }
    public void DeleteBook(int id){
    //Book deletedBook = bookData.stream().filter(e ->e.getId()!=id).findFirst().get();
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book, int id) {
//       bookData=  bookData.stream().map(b->{
//                if(b.getId()==id){
//                    b.setValue(book.getValue());
//                }
//                return b;
//                }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }
}
