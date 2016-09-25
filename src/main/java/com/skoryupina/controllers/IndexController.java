package com.skoryupina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final String template = "Hello, %s!";

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String sayHello(@RequestParam(value="name", required=false, defaultValue="world") String name) {
        return (String.format(template, name));
    }

}
