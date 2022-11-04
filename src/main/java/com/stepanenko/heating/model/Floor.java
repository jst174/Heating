package com.stepanenko.heating.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private double height;
    private double highMark;
    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;
    @OneToMany(mappedBy = "floor")
    private Set<Room> rooms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Floor)) return false;
        Floor floor = (Floor) o;
        return number == floor.number && Double.compare(floor.height, height) == 0 && Double.compare(floor.highMark, highMark) == 0 && Objects.equals(id, floor.id) && Objects.equals(section, floor.section) && Objects.equals(rooms, floor.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, height, highMark, section, rooms);
    }

    public static class Builder {

        private Floor floor;

        public Builder() {
            floor = new Floor();
        }

        public Builder setId(Long id) {
            floor.setId(id);
            return this;
        }

        public Builder setNumber(int number) {
            floor.setNumber(number);
            return this;
        }

        public Builder setHeight(double height) {
            floor.setHeight(height);
            return this;
        }

        public Builder setHighMark(double highMark) {
            floor.setHighMark(highMark);
            return this;
        }

        public Builder setSection(Section section) {
            floor.setSection(section);
            return this;
        }

        public Builder setRooms(Set<Room> rooms) {
            floor.setRooms(rooms);
            return this;
        }

        public Floor build() {
            return floor;
        }
    }
}
