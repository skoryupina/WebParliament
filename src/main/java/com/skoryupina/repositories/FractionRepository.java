package com.skoryupina.repositories;

import com.skoryupina.entities.Fraction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FractionRepository extends CrudRepository<Fraction, Integer> {
    List<Fraction> findByName(String name);
}
