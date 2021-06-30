package com.project.gym.gymbackend.dto;


import lombok.Data;

import java.util.Date;

@Data
public class PaymentDto {
    private long id;

    private double cost;

    private Date date;

    private String duration;
}
