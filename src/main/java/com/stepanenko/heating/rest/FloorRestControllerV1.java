package com.stepanenko.heating.rest;

import com.stepanenko.heating.model.Floor;
import com.stepanenko.heating.service.FloorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/floors/")
public class FloorRestControllerV1 {

    final FloorService floorService;

    public FloorRestControllerV1(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping
    public ResponseEntity<Floor> saveFloor(@RequestBody Floor floor) {
        floorService.save(floor);
        return new ResponseEntity<>(floor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable Long id) {
        Floor floor = floorService.getById(id);
        return new ResponseEntity<>(floor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Floor>> getAllFloors() {
        List<Floor> floors = floorService.getAll();
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Floor> updateFloor(@RequestBody Floor floor) {
        floorService.save(floor);
        return new ResponseEntity<>(floor, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Floor> deleteFloor(@PathVariable Long id) {
        floorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
