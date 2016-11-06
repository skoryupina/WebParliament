package com.skoryupina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "party")
@Access(AccessType.FIELD)
public class Party implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private Integer phoneNumber;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="leader_id", nullable = false)
    private Deputy leader;

    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY)
    @JoinColumn(name = "id_party", nullable = true)
    private Set<Deputy> deputies;

    @Embedded
    private Address address;

    public Party() {
    }

    public Party(String name, Integer phoneNumber, Deputy leader, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.leader = leader;
        this.address = address;
    }

    //region getters_and_setters
    @JsonIgnore
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonIgnore
    public Deputy getLeader() {
        return leader;
    }

    public void setLeader(Deputy leader) {
        this.leader = leader;
    }

    @JsonIgnore
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonIgnore
    public Set<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(Set<Deputy> deputies) {
        this.deputies = deputies;
    }

    //endregion


//    @Override
//    public String toString() {
//        return "Party{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", phoneNumber=" + phoneNumber +
//                ", leader=" + leader +
//                ", deputies=" + deputies +
//                ", address=" + address +
//                '}';
//    }
}
