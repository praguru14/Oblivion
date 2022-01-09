package com.pg.obv.controllers;

import com.pg.obv.models.Book;
import com.pg.obv.services.ProjServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {
	@Autowired
	ProjServices projServices;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public List<Book> bookData(){
		return projServices.getBooks();
	}

	@RequestMapping(value="/bookid",method = RequestMethod.GET)
	public Book bookById(@RequestParam("id") int id){
	return projServices.getSingleBookById(id);
	}

	@RequestMapping(value="/books",method = RequestMethod.POST)
	public Book postBooks(@RequestBody Book book){
		Book b = projServices.postBooks(book);
		return book;
	}

	@RequestMapping(value = "books/{id}",method = RequestMethod.DELETE)
	public Book deleteBookHandler(@PathVariable("id") int id){
	return projServices.DeleteBook(id);
	}

	@RequestMapping(value = "books/{id}",method = RequestMethod.PUT)
	public void updateBookData(@RequestBody Book book,@PathVariable("id") int id){
		 projServices.updateBook(book,id);
	}
	
}