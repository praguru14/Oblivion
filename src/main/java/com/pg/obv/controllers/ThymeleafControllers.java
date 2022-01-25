package com.pg.obv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeleafControllers {

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(){
        return "about";
    }
}
