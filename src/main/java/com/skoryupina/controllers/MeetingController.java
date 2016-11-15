package com.skoryupina.controllers;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.Meeting;
import com.skoryupina.forms.MeetingForm;
import com.skoryupina.services.DeputyService;
import com.skoryupina.services.MeetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private DeputyService deputyService;
    private MeetingsService meetingsService;

    @Autowired
    public void setDeputyService(DeputyService deputyService) {
        this.deputyService = deputyService;
    }

    @Autowired
    public void setMeetingsService(MeetingsService meetingsService) {
        this.meetingsService = meetingsService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("meetings", meetingsService.listAllMeetings());
        return "meetings";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editMeeting(@RequestParam("id") Integer id, Model model){
        MeetingForm meetingForm = new MeetingForm();
        meetingForm.feed(meetingsService.findById(id), deputyService.listAllDeputies());
        model.addAttribute("meetingForm", meetingForm);
        model.addAttribute("edit", true);
        return "forms/meetingform";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createMeeting(Model model){
        MeetingForm meetingForm = new MeetingForm();
        Meeting meeting = new Meeting();
        Iterable<Deputy> deputiesInWebParliament = deputyService.listAllDeputies();
        meetingForm.feed(meeting,deputiesInWebParliament);
        model.addAttribute("meetingForm", meetingForm);
        model.addAttribute("edit", false);
        return "forms/meetingform";
    }

    @RequestMapping(value = "/meeting", method = RequestMethod.POST)
    public String saveDeputy(@RequestParam(name = "chosenDeputies[]") String[] chosenDeputies, MeetingForm meetingForm){
        Meeting meeting;
        if (meetingForm.getId()==null){
            //редактирование
            meeting = new Meeting();
        }else{
            meeting = meetingsService.findById(meetingForm.getId());
        }
        meeting.setTopic(meetingForm.getTopic());
        //чтение даты
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = new Date();
            date = df.parse(meetingForm.getDate());
            meeting.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (chosenDeputies.length != 0){
            Set<Deputy> newDeputies = new HashSet<>();
            for (String idStr : chosenDeputies) {
                Integer id = Integer.parseInt(idStr);
                Deputy deputy = deputyService.findById(id);
                deputy.getMeetings().add(meeting);
                newDeputies.add(deputy);
            }
            meeting.setDeputies(newDeputies);
        }
        meetingsService.saveMeeting(meeting);
        return "redirect:/meetings";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String view(@RequestParam("id") Integer id, Model model){
        MeetingForm meetingForm = new MeetingForm();
        meetingForm.feed(meetingsService.findById(id),deputyService.listAllDeputies());
        model.addAttribute("meetingForm", meetingForm);
        return "views/meetingview";
    }


    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String remove(@RequestParam("id") Integer id){
        meetingsService.removeMeeting(id);
        return "redirect:/meetings";
    }

}
