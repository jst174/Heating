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
public class Floor {

    private int number;
    private double height;
    private double highMark;
    private List<Room> rooms;
}
