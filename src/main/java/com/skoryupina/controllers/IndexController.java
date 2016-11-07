package com.skoryupina.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

//    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

}
