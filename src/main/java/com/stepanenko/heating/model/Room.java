package com.stepanenko.heating.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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

    public static class Builder {

        private Room room;

        public Builder() {
            room = new Room();
        }

        public Builder setId(Long id) {
            room.setId(id);
            return this;
        }

        public Builder setNumber(String number) {
            room.setNumber(number);
            return this;
        }

        public Builder setName(String name) {
            room.setName(name);
            return this;
        }

        public Builder setTemperature(int temperature) {
            room.setTemperature(temperature);
            return this;
        }

        public Room build(){
            return room;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Room room = (Room) o;
        return id != null && Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
