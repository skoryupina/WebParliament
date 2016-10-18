package com.skoryupina.services;

import com.skoryupina.entities.Meeting;
import com.skoryupina.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class MeetingsServiceImpl implements MeetingsService {

    private MeetingRepository meetingRepository;

    @Autowired
    public void setMeetingRepository(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Iterable<Meeting> listAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> findByDate(Date date) {
        return meetingRepository.findByDate(date);
    }
}
