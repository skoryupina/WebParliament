package com.skoryupina.forms;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.Meeting;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MeetingForm {

    private Integer id;
    private Date date;
    private String topic;
    private Map<Deputy, Boolean> deputies = new HashMap<>();

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Map<Deputy, Boolean> getDeputies() {
        return deputies;
    }

    private void setDeputies(@Nullable Set<Deputy> deputiesInMeeting,@Nullable  Iterable<Deputy> deputiesInWebParliament) {
        if (deputiesInMeeting == null || deputiesInMeeting.size()==0) {
            for (Deputy deputy : deputiesInWebParliament) {
                deputies.put(deputy, false);
            }
        }else {
            for (Deputy deputy : deputiesInWebParliament) {
                deputies.put(deputy, deputiesInMeeting.contains(deputy));
            }
        }
    }
    //endregion

    public void feed(Meeting meeting, Iterable<Deputy> deputiesInWebParliament) {
        setId(meeting.getId());
        setTopic(meeting.getTopic());
        setDeputies(meeting.getDeputies(), deputiesInWebParliament);
    }




}
