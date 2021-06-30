package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String address;

    private String city;

    private int area;

    private String logo;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "gym")
    private List<Worktime>worktimes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Sport> sports;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Arbitrate> arbitrates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Train> trains;

    public Gym() {
        super();
    }

    public Gym(String name, String address, String city, int area, String logo, List<Worktime> worktimes, List<Sport> sports, List<Arbitrate> arbitrates, List<Train> trains) {
        super();
        this.name = name;
        this.address = address;
        this.city = city;
        this.area = area;
        this.logo = logo;
        this.worktimes = worktimes;
        this.sports = sports;
        this.arbitrates = arbitrates;
        this.trains = trains;
    }

    public void addWorktime(Worktime worktime){
        if (getWorktimes()==null){
            this.worktimes=new ArrayList<>();
        }
        getWorktimes().add(worktime);
        worktime.setGym(this);
    }

    public void addSportForGym(Sport sport){
        if (getSports()==null){
            this.sports=new ArrayList<>();
        }
        getSports().add(sport);
        sport.setGym(this);
    }
    public void addArbitrate(Arbitrate arbitrate){
        if (getArbitrates()==null){
            this.arbitrates=new ArrayList<>();
        }
        getArbitrates().add(arbitrate);
        arbitrate.setGym(this);
    }
    public void addTrain(Train train){
        if (getTrains()==null) {
            this.trains=new ArrayList<>();
        }
        getTrains().add(train);
        train.setGym(this);
    }
}
