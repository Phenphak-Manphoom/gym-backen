package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Arbitrate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Sport sport;

    @ManyToOne
    private Gym gym;

    public Arbitrate() {
        super();
    }

    public Arbitrate(String name, Sport sport, Gym gym) {
        super();
        this.name = name;
        this.sport = sport;
        this.gym = gym;
    }

}
