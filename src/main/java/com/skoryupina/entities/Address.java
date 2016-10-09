package com.skoryupina.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    @Column(nullable = false, length = 10)
    private String city;

    @Column(nullable = false, length = 15)
    private String district;

    @Column(nullable = false, length = 15)
    private String street;

    @Column(nullable = false)
    private Integer house;

    public Address() {
    }

    public Address(String city, String district, String street, Integer house) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.house = house;
    }

    //region getters_and_setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }
    //endregion
}
