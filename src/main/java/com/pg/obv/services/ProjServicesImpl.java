package com.pg.obv.services;


import com.pg.obv.dao.BookRepository;
import com.pg.obv.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


@Component
@Service
public class ProjServicesImpl implements ProjServices {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book>  getBooks() {
      List<Book> list = (List<Book>) bookRepository.findAll();
        return  list;
    }

    public Book getSingleBookById(int id){
        Book ID  =  bookRepository.findById(id);
    return ID;
    }

    public Book postBooks(Book b){
       Book book = bookRepository.save(b);
        return book;
    }
    public void DeleteBook(int id){
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
    }
}
