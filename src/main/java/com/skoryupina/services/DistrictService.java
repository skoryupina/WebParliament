package com.skoryupina.services;

import com.skoryupina.entities.District;

public interface DistrictService {
    Iterable<District> listAllDistricts();

    District saveDistrict(District district);

    District findByName(String name);

    District findById(Integer id);
}
