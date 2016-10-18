package com.skoryupina.repositories;

import com.skoryupina.entities.Deputy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeputyRepository extends CrudRepository<Deputy,Integer> {
    List<Deputy> findBySurname(String surname);
}
