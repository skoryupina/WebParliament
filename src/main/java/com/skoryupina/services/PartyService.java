package com.skoryupina.services;

import com.skoryupina.entities.Party;

import java.util.List;

public interface PartyService {
    Iterable<Party> listAllParties();

    Party saveParty(Party party);

    List<Party> findByName(String name);

    Party findById(Integer id);
}
