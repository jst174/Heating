package com.stepanenko.heating.repository;

import com.stepanenko.heating.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
