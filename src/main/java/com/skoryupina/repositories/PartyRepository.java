package com.skoryupina.repositories;

import com.skoryupina.entities.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Integer> {
    Party findByName(String name);
}
