package com.skoryupina.repositories;

import com.skoryupina.entities.Fraction;
import org.springframework.data.repository.CrudRepository;

public interface FractionRepository extends CrudRepository<Fraction, Integer> {
}
