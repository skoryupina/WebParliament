package com.skoryupina.repositories;

import com.skoryupina.entities.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartyRepository extends CrudRepository<Party, Integer> {
    List<Party> findByName(String name);
}
