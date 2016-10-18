package com.skoryupina.controllers;

import com.skoryupina.entities.District;
import com.skoryupina.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
        District district = new District();
        model.addAttribute("districts", districtService.listAllDistricts());
        model.addAttribute("district", district);
        return "districts";
    }

    @PostMapping("/district")
    public String districtSubmit(District district){
        districtService.saveDistrict(district);
        return "districts";
    }
}
