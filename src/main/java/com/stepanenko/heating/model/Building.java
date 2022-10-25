package com.stepanenko.heating.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Building {

    private Long id;
    private double height;
    private String appointment;
    private int averageIndoorAirTemperature;
    private List<Floor> floors;

}
