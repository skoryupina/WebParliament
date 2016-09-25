package com.skoryupina.controllers;

import com.skoryupina.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistrictController {

    private DistrictService districtService;

    @Autowired
    public void setDistrictService(DistrictService districtService){
        this.districtService = districtService;
    }

    @RequestMapping(value = "/districts", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("districts", districtService.listAllDistricts());
        return "districts";
    }
}
