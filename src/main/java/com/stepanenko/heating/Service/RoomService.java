package com.stepanenko.heating.Service;

import com.stepanenko.heating.model.Room;
import com.stepanenko.heating.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static java.lang.String.format;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

    public Room getById(Long id) throws EntityNotFoundException {
        return roomRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(format("Room with id = %s is not found", id)));
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
