package com.skoryupina.forms;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.Party;

public class PartyForm {
    private Integer id;
    private String name;
    private Integer phoneNumber;
    private String leaderData;
    private Integer leaderID;
    private Iterable<Deputy> deputies;
    private String city;
    private String district;
    private String street;
    private Integer house;

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLeaderData() {
        return leaderData;
    }

    public void setLeaderData(Deputy leader) {
        this.leaderData = leader.getSurname() + " " + leader.getName();
    }

    public Integer getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(Deputy leader) {
        this.leaderID = leader.getId();
    }

    public Iterable<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(Iterable<Deputy> deputies) {
        this.deputies = deputies;
    }

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

    public void feed(Party party){
        setId(party.getId());
        setName(party.getName());
        setPhoneNumber(party.getPhoneNumber());
        setLeaderData(party.getLeader());
        setLeaderID(party.getLeader());
        setDeputies(party.getDeputies());
    }
}
