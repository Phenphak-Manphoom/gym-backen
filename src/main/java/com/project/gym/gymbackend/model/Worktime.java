package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Worktime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String day;

    @Temporal(TemporalType.DATE)
    private Date timetable;

    private String start;

    private String end;

    @ManyToOne
    private Gym gym;

    @OneToMany(mappedBy = "Worktime")
    private List<SportsMan> sportsMans;

    public Worktime() {
        super();
    }

    public Worktime(String day, Date timetable, String start, String end, Gym gym, List<SportsMan> sportsMans) {
        super();
        this.day = day;
        this.timetable = timetable;
        this.start = start;
        this.end = end;
        this.gym = gym;
        this.sportsMans = sportsMans;
    }

    public void addSportsManForWork(SportsMan sportsMan) {
        if (getSportsMans()==null) {
            this.sportsMans = new ArrayList<>();
        }
        getSportsMans().add(sportsMan);
        sportsMan.setWorktime(this);
    }
}
