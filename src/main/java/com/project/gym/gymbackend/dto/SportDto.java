package com.project.gym.gymbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SportDto {
    private long id;

    private String name;

    private String description;

    private String photo;

    private List<ArbitrateDto> arbitrates;

    private List<TrainDto> trains;
}
