package com.skoryupina.controllers;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.District;
import com.skoryupina.services.DeputyService;
import com.skoryupina.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/districts")
public class DistrictController {

    private DistrictService districtService;
    private DeputyService deputyService;

    @Autowired
    public void setDistrictService(DistrictService districtService){
        this.districtService = districtService;
    }

    @Autowired
    public void setDeputyService(DeputyService deputyService) {
        this.deputyService = deputyService;
    }

    @RequestMapping("")
    public String index(Model model,  @ModelAttribute("haswarn") final Object hasWarn,@ModelAttribute("warn") final Object warn ) {
        model.addAttribute("districts", districtService.listAllDistricts());
        model.addAttribute("district", new District());
        if (hasWarn.equals(Boolean.TRUE)){
            model.addAttribute("haswarn", true);
            model.addAttribute("warn", warn);
        }else{
            model.addAttribute("haswarn", false);
        }
        return "districts";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        System.out.println("edit");
        System.out.println(districtService.findById(id));
        model.addAttribute("district", districtService.findById(id));
        return "forms/districtform";
    }

    @RequestMapping(value = "/district", method = RequestMethod.POST)
    public String saveDistrict(District district){
        System.out.println("save");
        System.out.println(district.toString());
        districtService.saveDistrict(district);
        return "redirect:/districts";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String remove(@RequestParam("id") Integer id, final RedirectAttributes redirectAttributes){
        Iterable<Deputy> deputies = deputyService.listAllDeputies();
        List<Deputy> districtDeputies = new LinkedList<>();
        for (Deputy deputy : deputies){
            if (deputy.getDistrict().getId().equals(id)){
                districtDeputies.add(deputy);
            }
        }
        //если депутатов нет - удаляем
        if (districtDeputies.size() > 0){
            redirectAttributes.addFlashAttribute("haswarn", true);
            redirectAttributes.addFlashAttribute("warn", "Невозможно удалить округ. Прикреплены " + districtDeputies.size() + " депутата(-ов). ");
            return "redirect:/districts";
        }else{
            redirectAttributes.addFlashAttribute("haswarn", false);
            districtService.removeDistrict(id);
            return "redirect:/districts";
        }
    }

    @RequestMapping("/districtsNames")
    public @ResponseBody Iterable<District> districtJson() {
        return districtService.listAllDistricts();
    }
}
