package com.skoryupina.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "district")
public class District implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column (name ="name", unique = true, nullable = false, length = 20)
    private String name;

    public District(){}

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public District(String name) {
        this.name = name;
    }

    //region getters_and_setters
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
    //endregion

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
