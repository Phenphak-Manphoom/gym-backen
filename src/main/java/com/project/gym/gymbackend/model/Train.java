package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Sport sport;

    @ManyToOne
    private Gym gym;

    public Train() {
        super();
    }

    public Train(String name, Sport sport, Gym gym) {
        super();
        this.name = name;
        this.sport = sport;
        this.gym = gym;
    }
}
