package com.skoryupina.services;

import com.skoryupina.entities.District;
import com.skoryupina.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;


    @Override
    public Iterable<District> listAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> findByName(String name) {
        return districtRepository.findByName(name);
    }
}
