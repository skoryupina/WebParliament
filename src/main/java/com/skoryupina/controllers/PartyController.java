package com.skoryupina.controllers;

import com.skoryupina.entities.Party;
import com.skoryupina.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/parties")
public class PartyController {
    private PartyService partyService;

    @Autowired
    public void setPartyService(PartyService partyService){
        this.partyService = partyService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("parties", partyService.listAllParties());
        model.addAttribute("party", new Party());
        return "parties";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        System.out.println("edit");
        System.out.println(partyService.findById(id));
        model.addAttribute("party", partyService.findById(id));
        return "forms/partyform";
    }

    @RequestMapping(value = "/party", method = RequestMethod.POST)
    public String saveParty(Party party){
        System.out.println("save");
        System.out.println(party.toString());
        partyService.saveParty(party);
        return "redirect:/parties";
    }

    @RequestMapping("/partiesNames")
    public @ResponseBody Iterable<Party> partiesJson() {
        return partyService.listAllParties();
    }
}
