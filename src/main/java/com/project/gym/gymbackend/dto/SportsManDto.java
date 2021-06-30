package com.project.gym.gymbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SportsManDto {

    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private String sex;

    private String avatar;

    private List<SportDto> sports;

    private List<PaymentDto> payments;

}
