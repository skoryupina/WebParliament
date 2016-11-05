package com.skoryupina.repositories;

import com.skoryupina.entities.District;
import org.springframework.data.repository.CrudRepository;

public interface DistrictRepository extends CrudRepository<District,Integer> {
    District findByName(String name);
}
