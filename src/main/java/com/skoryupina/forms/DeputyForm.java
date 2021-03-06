package com.skoryupina.forms;

import com.skoryupina.entities.Deputy;
import com.skoryupina.entities.JobType;

public class DeputyForm {
    private Integer id;
    private String surname;
    private String name;
    private String job;
    private String image;
    private boolean avaExists;
    private String district;
    private String party;

    public DeputyForm() {
        this.job = JobType.ORDINARY.toString();
    }

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getAva() {
        return avaExists;
    }

    public void setAva(boolean isImageNull) {
        this.avaExists = isImageNull;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    //endregion

    public void feed(Deputy deputy){
        setId(deputy.getId());
        setSurname(deputy.getSurname());
        setName(deputy.getName());
        setJob(deputy.getJob().toString());
        setImage(deputy.getImage());
        setAva(deputy.isImageNull());
        setDistrict(deputy.getDistrict().getName());
        setParty(deputy.getParty().getName());
    }
}
