package com.skoryupina.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "fraction")
@Access(AccessType.FIELD)
public class Fraction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "phonenumber", nullable = false, unique = true)
    private Integer phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fraction_id", nullable = true)
    private Set<Party> parties;

    public Fraction() {
    }

    public Fraction(String name, Integer phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }



    //region getters_and_setters
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //endregion
}
