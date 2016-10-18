package com.skoryupina.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "deputy")
@Access(AccessType.FIELD)
public class Deputy implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="surname", nullable = false, length = 20)
    private String surname;

    @Column(name ="name", nullable = false, length = 10)
    private String name;

    @Column(name ="job", nullable = false)
    @Enumerated(EnumType.STRING)
    private JobType job;

    @ManyToMany(mappedBy = "deputies")
    @OrderBy("date DESC")
    private Set<Meeting> meetings;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_district", nullable = false)
    private District district;

    public Deputy() {
    }

    public Deputy(String surname, String name, JobType job) {
        this.surname = surname;
        this.name = name;
        this.job = job;
    }

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
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

    public JobType getJob() {
        return job;
    }

    public void setJob(JobType job) {
        this.job = job;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }
    //endregion
}
