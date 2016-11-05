package com.skoryupina.services;

import com.skoryupina.entities.District;
import com.skoryupina.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    private DistrictRepository districtRepository;

    @Autowired
    public void setDistrictRepository(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    @Override
    public Iterable<District> listAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District findByName(String name) {
        return districtRepository.findByName(name);
    }

    @Override
    public District findById(Integer id) {
        return districtRepository.findOne(id);
    }
}
