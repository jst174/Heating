package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Room;
import com.stepanenko.heating.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void save(Room room) {
        log.info("IN RoomService save {}", room);
        roomRepository.save(room);
    }

    public Room getById(Long id) throws EntityNotFoundException {
        log.info("IN RoomService getById {}", id);
        return roomRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(format("Room with id = %s is not found", id)));
    }

    public List<Room> getAll() {
        log.info("IN RoomService getAll");
        return roomRepository.findAll();
    }

    public void delete(Long id) {
        log.info("IN RoomService delete {}", id);
        roomRepository.deleteById(id);
    }
}
