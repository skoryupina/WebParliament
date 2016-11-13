package com.skoryupina.controllers;

import com.skoryupina.entities.Fraction;
import com.skoryupina.entities.Party;
import com.skoryupina.forms.FractionForm;
import com.skoryupina.services.FractionService;
import com.skoryupina.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/fractions")
public class FractionController {
    private FractionService fractionService;
    private PartyService partyService;

    @Autowired
    public void setFractionService(FractionService fractionService) {
        this.fractionService = fractionService;
    }

    @Autowired
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("fractions", fractionService.listAllFractions());
        return "fractions";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model) {
        FractionForm fractionForm = new FractionForm();
        fractionForm.feed(fractionService.findById(id), partyService.listAllParties());
        model.addAttribute("fractionForm", fractionForm);
        model.addAttribute("edit", true);
        return "forms/fractionform";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String remove(@RequestParam("id") Integer id){
        fractionService.removeFraction(id);
        return "redirect:/fractions";
    }

    @RequestMapping(value = "/fraction", method = RequestMethod.POST)
    public String saveFraction(@RequestParam(name = "chosen[]") String[] chosenParties, FractionForm fractionForm) {
        Fraction fraction;
        if (fractionForm.getId() == null) {
            fraction = new Fraction();
            fraction.setName(fractionForm.getName());
            fraction = fractionService.saveFraction(fraction);
        }else{
            fraction = fractionService.findById(fractionForm.getId());
            fraction.setName(fractionForm.getName());
        }
        if (chosenParties.length != 0) {
            Set<Party> newParties = new HashSet<>();
            for (String idStr : chosenParties) {
                Integer id = Integer.parseInt(idStr);
                Party party = partyService.findById(id);
                party.setFraction(fraction);
                newParties.add(party);
                partyService.saveParty(party);
            }
            fraction.setParties(newParties);
            fractionService.saveFraction(fraction);
        }
        return "redirect:/fractions";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createFraction(Model model) {
        FractionForm fractionForm = new FractionForm();
        Fraction fraction = new Fraction();
        Iterable<Party> partiesInWebParliament = partyService.listAllParties();
        fractionForm.feed(fraction, partiesInWebParliament);
        model.addAttribute("fractionForm", fractionForm);
        model.addAttribute("edit", false);
        return "forms/fractionform";
    }
}
