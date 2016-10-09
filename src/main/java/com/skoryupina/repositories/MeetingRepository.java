package com.skoryupina.repositories;

import com.skoryupina.entities.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
}
