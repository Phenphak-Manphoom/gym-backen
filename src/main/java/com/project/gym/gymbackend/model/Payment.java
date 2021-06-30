package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double cost;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String duration;

    @ManyToOne
    private SportsMan sportsMan;

    public Payment() {
        super();
    }

    public Payment(double cost, Date date, String duration, SportsMan sportsMan) {
        super();
        this.cost = cost;
        this.date = date;
        this.duration = duration;
        this.sportsMan = sportsMan;
    }
}
