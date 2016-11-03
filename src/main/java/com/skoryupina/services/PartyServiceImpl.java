package com.skoryupina.services;

import com.skoryupina.entities.Party;
import com.skoryupina.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public Party findById(Integer id) {
        return partyRepository.findOne(id);
    }
}
