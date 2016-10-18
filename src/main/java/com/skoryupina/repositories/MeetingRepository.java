package com.skoryupina.repositories;

import com.skoryupina.entities.Meeting;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
    List<Meeting> findByDate(Date date);
}
