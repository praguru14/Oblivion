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
	

	
}
