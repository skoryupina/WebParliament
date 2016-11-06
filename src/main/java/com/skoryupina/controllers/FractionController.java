package com.skoryupina.controllers;

import com.skoryupina.entities.Fraction;
import com.skoryupina.services.FractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fractions")
public class FractionController {
    private FractionService fractionService;

    @Autowired
    public void setFractionService(FractionService fractionService){
        this.fractionService = fractionService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("fractions", fractionService.listAllFractions());
        return "fractions";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        System.out.println("edit");
        System.out.println(fractionService.findById(id));
        model.addAttribute("fraction", fractionService.findById(id));
        return "forms/fractionform";
    }

    @RequestMapping(value = "/fraction", method = RequestMethod.POST)
    public String saveFraction(Fraction fraction){
        System.out.println("save");
        System.out.println(fraction.toString());
        fractionService.saveFraction(fraction);
        return "redirect:/fractions";
    }
}
