package com.skoryupina.controllers;

import com.skoryupina.entities.Address;
import com.skoryupina.entities.Party;
import com.skoryupina.forms.PartyForm;
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
        return "parties";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, Model model){
        PartyForm partyForm = new PartyForm();
        partyForm.feed(partyService.findById(id));
        model.addAttribute("partyForm", partyForm);
        model.addAttribute("edit", true);
        return "forms/partyform";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String view(@RequestParam("id") Integer id, Model model){
        PartyForm partyForm = new PartyForm();
        partyForm.feed(partyService.findById(id));
        model.addAttribute("partyForm", partyForm);
        return "views/partyview";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createParty(Model model){
        PartyForm partyForm = new  PartyForm();
        model.addAttribute("partyForm", partyForm);
        model.addAttribute("edit", false);
        return "forms/partyform";
    }

    @RequestMapping(value = "/party", method = RequestMethod.POST)
    public String saveParty(PartyForm partyForm){
        Party party;
        if (partyForm.getId()!=null){
            //редактирование
            party = partyService.findById(partyForm.getId());
        }else{
            party = new Party();
        }

        party.setName(partyForm.getName());
        party.setPhoneNumber(partyForm.getPhoneNumber());

        Address address = new Address();
        address.setCity(partyForm.getCity());
        address.setDistrict(partyForm.getDistrict());
        address.setStreet(partyForm.getStreet());
        address.setHouse(partyForm.getHouse());

        if (!address.equals(party.getAddress())){
            party.setAddress(address);
        }

        partyService.saveParty(party);
        return "redirect:/parties";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String remove(@RequestParam("id") Integer id){
        partyService.removeParty(id);
        return "redirect:/parties";
    }

    @RequestMapping("/partiesNames")
    public @ResponseBody Iterable<Party> partiesJson() {
        return partyService.listAllParties();
    }
}
