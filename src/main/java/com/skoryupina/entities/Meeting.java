package com.skoryupina.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "meeting")
@Access(AccessType.FIELD)
public class Meeting implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column (name ="date", nullable = false)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="deputy_meeting",
            joinColumns = @JoinColumn(name="meeting_fk"),
            inverseJoinColumns = @JoinColumn(name="deputy_fk"))
    private Set<Deputy> deputies;

    public Meeting() {
    }

    public Meeting(Date date) {
        this.date = date;
    }

    //region getters_and_setters
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }
    //endregion


    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", date=" + date +
                ", deputies=" + deputies +
                '}';
    }
}
