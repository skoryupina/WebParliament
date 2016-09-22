package com.skoryupina.repositories;

import com.skoryupina.entities.District;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistrictRepository extends CrudRepository<District,Integer> {
    List<District> findByName(String name);
}
