package com.skoryupina.services;

import com.skoryupina.entities.Party;
import com.skoryupina.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Party findByName(String name) {
        return partyRepository.findByName(name);
    }

    @Override
    public Party findById(Integer id) {
        return partyRepository.findOne(id);
    }

    @Override
    public void removeParty(Integer id) {
        partyRepository.delete(id);
    }
}
