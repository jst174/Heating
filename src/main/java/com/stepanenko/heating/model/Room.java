package com.stepanenko.heating.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String name;
    private int temperature;
    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;
}
