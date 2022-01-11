package com.pg.obv.controllers;

import com.pg.obv.models.Book;
import com.pg.obv.services.ProjServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {
	@Autowired
	ProjServices projServices;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ResponseEntity<Book> bookData(){
		try{
			List<Book> list = projServices.getBooks();
			if(list.size()<=0){
				return new ResponseEntity(projServices.getBooks(),HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(projServices.getBooks(), HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/bookid",method = RequestMethod.GET)
	public ResponseEntity<Book> bookById(@RequestParam("id") int id){

		try {
			return new ResponseEntity(projServices.getSingleBookById(id),HttpStatus.OK);
		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/books",method = RequestMethod.POST)
	public ResponseEntity<Book> postBooks(@RequestBody Book book){
		Book b = projServices.postBooks(book);

		try {
			return new ResponseEntity(projServices.postBooks(b),HttpStatus.OK);
		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "books/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBookHandler(@PathVariable("id") int id){

		try {
			return new ResponseEntity(projServices.DeleteBook(id),HttpStatus.OK);
		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "books/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBookData(@RequestBody Book book, @PathVariable("id") int id){
		try {
			projServices.updateBook(book,id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
}