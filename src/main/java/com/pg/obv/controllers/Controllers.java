package com.pg.obv.controllers;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	
	@GetMapping("/")
	public String Hello(@RequestParam(required = true) String name ) {
		return name;
	}
	
	@PostMapping("/post")
	public String postMap() {
		String text = "";
		return text;
	}
	
}
