package com.skoryupina.controllers;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.JobType;
import com.skoryupina.forms.DeputyForm;
import com.skoryupina.services.DeputyService;
import com.skoryupina.services.DistrictService;
import com.skoryupina.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Controller
@RequestMapping("/deputies")
public class DeputyController {

    private DeputyService deputyService;
    private PartyService partyService;
    private DistrictService districtService;

    @Autowired
    public void setDeputyService(DeputyService deputyService){
        this.deputyService = deputyService;
    }

    @Autowired
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
    }

    @Autowired
    public void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
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
        DeputyForm deputyForm = new DeputyForm();
        deputyForm.feed(deputyService.findById(id));
        model.addAttribute("deputyForm", deputyForm);
        model.addAttribute("edit", true);
        return "forms/deputyform";
    }

    @RequestMapping(value = "/deputy", method = RequestMethod.POST)
    public String saveDeputy(DeputyForm deputyForm){
        System.out.println("save");
        Deputy deputy = new Deputy();
        deputy.setName(deputyForm.getName());
        deputy.setSurname(deputyForm.getSurname());
        deputy.setJob(JobType.getCorrespondingJobType(deputyForm.getJob()));
        deputy.setDistrict(districtService.findByName(deputyForm.getDistrict()));

        System.out.println(deputy.toString());
        deputyService.saveDeputy(deputy);
        return "redirect:/deputies";
    }

    @RequestMapping("/jobTypes")
    public @ResponseBody Iterable<String> partiesJson() {
        Field[] declaredFields = JobType.class.getFields();
        ArrayList<String> jobTypes = new ArrayList<>();
        for (Field field : declaredFields){
            jobTypes.add(field.getName());
        }
        return jobTypes;
    }


}