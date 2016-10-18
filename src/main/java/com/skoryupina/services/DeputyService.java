package com.skoryupina.services;

import com.skoryupina.entities.Deputy;

import java.util.List;

public interface DeputyService {
    Iterable<Deputy> listAllDeputies();

    Deputy saveDeputy(Deputy district);

    List<Deputy> findBySurname(String surname);
}
