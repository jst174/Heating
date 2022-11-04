package com.stepanenko.heating.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private double height;
    @OneToMany(mappedBy = "section")
    private Set<Floor> floors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Double.compare(section.height, height) == 0 && Objects.equals(id, section.id) && Objects.equals(floors, section.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, floors);
    }

    public static class Builder {

        private Section section;

        public Builder() {
            section = new Section();
        }

        public Builder setId(Long id) {
            section.setId(id);
            return this;
        }

        public Builder setNumber(String number) {
            section.setNumber(number);
            return this;
        }

        public Builder setHeight(double height) {
            section.setHeight(height);
            return this;
        }

        public Builder setFloors(Set<Floor> floors) {
            section.setFloors(floors);
            return this;
        }

        public Section build() {
            return section;
        }
    }
}
