package com.skoryupina.services;

import com.skoryupina.entities.District;

import java.util.List;

public interface DistrictService {
    Iterable<District> listAllDistricts();

    District saveDistrict(District district);

    List<District> findByName(String name);

    District getDistrictByName(String username);
}
