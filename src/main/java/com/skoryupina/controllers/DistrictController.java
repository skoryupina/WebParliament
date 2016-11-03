package com.skoryupina.controllers;

import com.skoryupina.entities.District;
import com.skoryupina.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/districts")
public class DistrictController {

    private DistrictService districtService;

    @Autowired
    public void setDistrictService(DistrictService districtService){
        this.districtService = districtService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("districts", districtService.listAllDistricts());
        model.addAttribute("district", new District());
        return "districts";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        System.out.println("edit");
        System.out.println(districtService.findById(id));
        model.addAttribute("district", districtService.findById(id));
        return "districtform";
    }

    @RequestMapping(value = "/district", method = RequestMethod.POST)
    public String saveDistrict(District district){
        System.out.println("save");
        System.out.println(district.toString());
        districtService.saveDistrict(district);
        return "redirect:/districts";
    }
}
