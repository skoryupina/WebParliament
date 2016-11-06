package com.skoryupina.services;

import com.skoryupina.entities.Party;

public interface PartyService {
    Iterable<Party> listAllParties();

    Party saveParty(Party party);

    Party findByName(String name);

    Party findById(Integer id);
}
