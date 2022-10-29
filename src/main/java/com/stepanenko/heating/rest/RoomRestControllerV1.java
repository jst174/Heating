package com.stepanenko.heating.rest;

import com.stepanenko.heating.Service.RoomService;
import com.stepanenko.heating.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms/")
public class RoomRestControllerV1 {

    private final RoomService roomService;

    public RoomRestControllerV1(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Room room = roomService.getById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = roomService.getAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id) {
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
