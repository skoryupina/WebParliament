package com.skoryupina.repositories;

import com.skoryupina.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District,UUID> {
    List<District> findByName(String name);
}
