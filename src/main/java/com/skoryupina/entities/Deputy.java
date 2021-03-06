package com.skoryupina.entities;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "deputy")
@Access(AccessType.FIELD)
public class Deputy implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name ="surname", nullable = false, length = 20)
    private String surname;

    @Column(name ="name", nullable = false, length = 10)
    private String name;

    @Column(name ="job", nullable = false)
    @Enumerated(EnumType.STRING)
    private JobType job;

    @Lob
    @Column(name="image", nullable=true, columnDefinition="bytea")
    private byte[] image;

    @ManyToMany(mappedBy = "deputies")
    @OrderBy("date DESC")
    private Set<Meeting> meetings;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_district", nullable = false)
    private District district;

    private Party party;

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

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getImage() {
        return Base64.encodeBase64String(image);
    }

    public boolean isImageNull(){
        System.out.println("Image null? " + (image==null));
        return image==null;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deputy deputy = (Deputy) o;
        return Objects.equals(id, deputy.id) &&
                Objects.equals(surname, deputy.surname) &&
                Objects.equals(name, deputy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name);
    }


//    @Override
//    public String toString() {
//        return "Deputy{" +
//                "id=" + id +
//                ", surname='" + surname + '\'' +
//                ", name='" + name + '\'' +
//                ", job=" + job +
//                ", meetings=" + meetings +
//                ", district=" + district +
//                ", party=" + party +
//                '}';
//    }
}
