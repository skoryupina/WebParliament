package com.skoryupina.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllOkrugs", query = "SELECT d FROM District d"),
        @NamedQuery(name = "findMultiMemberConstituency", query = "SELECT d FROM District d WHERE d.name='Multi-member constituencies'")
})
public class District implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=3, max=40)
    private String name;

    public District(){}

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public District(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
