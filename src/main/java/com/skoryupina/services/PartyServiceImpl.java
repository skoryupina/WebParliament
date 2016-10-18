package com.skoryupina.services;

import com.skoryupina.entities.Party;
import com.skoryupina.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PartyServiceImpl implements PartyService {

    private PartyRepository partyRepository;

    @Autowired
    public void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Iterable<Party> listAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public List<Party> findByName(String name) {
        return partyRepository.findByName(name);
    }
}
