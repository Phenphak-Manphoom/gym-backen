package com.project.gym.gymbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class GymDto {
    private long id;
    private String name;
    private String address;
    private String city;
    private int area;
    private String logo;
    private List<WorktimeDto> worktimes;
    private List<SportDto> sports;
    private List<ArbitrateDto> arbitrates;
    private List<TrainDto> trains;
}
