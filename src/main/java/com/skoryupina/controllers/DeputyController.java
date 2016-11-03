package com.skoryupina.controllers;

import com.skoryupina.entities.Deputy;
import com.skoryupina.services.DeputyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/deputies")
public class DeputyController {

    private DeputyService deputyService;

    @Autowired
    public void setDeputyService(DeputyService deputyService){
        this.deputyService = deputyService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("deputies", deputyService.listAllDeputies());
        model.addAttribute("deputy", new Deputy());
        return "deputies";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        System.out.println("edit");
        System.out.println(deputyService.findById(id));
        model.addAttribute("deputy", deputyService.findById(id));
        return "forms/deputyform";
    }

    @RequestMapping(value = "/deputy", method = RequestMethod.POST)
    public String saveDeputy(Deputy deputy){
        System.out.println("save");
        System.out.println(deputy.toString());
        deputyService.saveDeputy(deputy);
        return "redirect:/deputies";
    }
}
