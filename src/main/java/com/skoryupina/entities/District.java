package com.skoryupina.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllOkrugs", query = "SELECT d FROM District d"),
        @NamedQuery(name = "findMultiMemberConstituency", query = "SELECT d FROM District d WHERE d.name='Multi-member constituencies'")
})
@Table(name = "district")
@Access(AccessType.FIELD)
public class District implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
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

    protected void setId(int id) {
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
