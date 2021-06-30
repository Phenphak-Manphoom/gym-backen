package com.project.gym.gymbackend.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WorktimeDto {

    private long id;

    private String day;

    private Date timetable;

    private String start;

    private String end;

    private List<SportsManDto> sportsMans;
}
