package com.skoryupina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "meeting")
@Access(AccessType.FIELD)
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = true)
    private Date date;

    @Column(columnDefinition="text", name = "topic", nullable = true)
    private String topic;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "deputy_meeting",
            joinColumns = @JoinColumn(name = "meeting_fk"),
            inverseJoinColumns = @JoinColumn(name = "deputy_fk"))
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Set<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(Set<Deputy> deputies) {
        this.deputies = deputies;
    }

    public String getFormatted() {
        String month = DateFormat.getDateInstance(SimpleDateFormat.LONG, new Locale("ru")).format(getDate());
        return month;
    }


    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


//    @Override
//    public String toString() {
//        return "Meeting{" +
//                "id=" + id +
//                ", date=" + date +
//                ", deputies=" + deputies +
//                '}';
//    }
}
