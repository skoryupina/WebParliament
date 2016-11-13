package com.skoryupina.services;

import com.skoryupina.entities.Fraction;
import com.skoryupina.repositories.FractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FractionServiceImpl implements FractionService {

    private FractionRepository fractionRepository;

    @Autowired
    public void setFractionRepository(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;
    }

    @Override
    public Iterable<Fraction> listAllFractions() {
        return fractionRepository.findAll();
    }

    @Override
    public Fraction saveFraction(Fraction fraction) {
        return fractionRepository.save(fraction);
    }

    @Override
    public List<Fraction> findByName(String name) {
        return fractionRepository.findByName(name);
    }

    @Override
    public Fraction findById(Integer id) {
        return fractionRepository.findOne(id);
    }

    @Override
    public void removeFraction(Integer id) {
        fractionRepository.delete(id);
    }
}
