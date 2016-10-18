package com.skoryupina.services;

import com.skoryupina.entities.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingsService {
    Iterable<Meeting> listAllMeetings();

    Meeting saveMeeting(Meeting meeting);

    List<Meeting> findByDate(Date date);
}
