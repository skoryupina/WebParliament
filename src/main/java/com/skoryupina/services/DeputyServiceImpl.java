package com.skoryupina.services;

import com.skoryupina.entities.Deputy;
import com.skoryupina.repositories.DeputyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeputyServiceImpl implements DeputyService{
    private DeputyRepository deputyRepository;

    @Autowired
    public void setDeputyRepository(DeputyRepository deputyRepository) {
        this.deputyRepository = deputyRepository;
    }


    @Override
    public Iterable<Deputy> listAllDeputies() {
        return deputyRepository.findAll();
    }

    @Override
    public Deputy saveDeputy(Deputy deputy) {
        return deputyRepository.save(deputy);
    }

    @Override
    public List<Deputy> findBySurname(String surname) {
        return deputyRepository.findBySurname(surname);
    }
}
