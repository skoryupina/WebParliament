package com.skoryupina.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class IndexService {
    @RequestMapping("/")
    public String showIndexString() {
        return "index";
    }
}
