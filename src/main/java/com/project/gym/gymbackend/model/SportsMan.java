package com.project.gym.gymbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SportsMan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private String sex;

    private String avatar;

    @ManyToOne
    private Worktime Worktime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportsMan")
    private List<Sport> sports;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportsMan")
    private List<Payment> payments;

    public SportsMan() {
        super();
    }

    public SportsMan(String firstName, String lastName, int age, String sex, String avatar, Worktime worktime, List<Sport> sports, List<Payment> payments) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.avatar = avatar;
        Worktime = worktime;
        this.sports = sports;
        this.payments = payments;
    }

    public void addSport(Sport sport){
        if (getSports()==null){
            this.sports=new ArrayList<>();
        }
        getSports().add(sport);
        sport.setSportsMan(this);
    }
    public void addPayment(Payment payment){
        if(getPayments()==null){
            this.payments=new ArrayList<>();
        }
        getPayments().add(payment);
        payment.setSportsMan(this);
    }
}
