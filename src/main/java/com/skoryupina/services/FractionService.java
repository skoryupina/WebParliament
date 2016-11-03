package com.skoryupina.services;

import com.skoryupina.entities.Fraction;

import java.util.List;

public interface FractionService {
    Iterable<Fraction> listAllFractions();

    Fraction saveFraction(Fraction fraction);

    List<Fraction> findByName(String name);

    Fraction findById(Integer id);
}
