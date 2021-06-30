package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private String photo;

    @ManyToOne
    private SportsMan sportsMan;

    @ManyToOne
    private Gym gym;

    @OneToMany(mappedBy = "sport")
    private List<Arbitrate> arbitrates;

    @OneToMany(mappedBy = "sport")
    private List<Train> trains;

    public Sport() {
        super();
    }

    public Sport(String name, String description, String photo, SportsMan sportsMan, Gym gym, List<Arbitrate> arbitrates, List<Train> trains) {
        super();
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.sportsMan = sportsMan;
        this.gym = gym;
        this.arbitrates = arbitrates;
        this.trains = trains;
    }

    public void addArbitrate(Arbitrate arbitrate) {
        if (getArbitrates()==null) {
            this.arbitrates = new ArrayList<>();
        }
        getArbitrates().add(arbitrate);
        arbitrate.setSport(this);
    }

    public void addTrain(Train train){
        if(getTrains()==null){
            this.trains=new ArrayList<>();
        }
        getTrains().add(train);
        train.setSport(this);
    }
}
