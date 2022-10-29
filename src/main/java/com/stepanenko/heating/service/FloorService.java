package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Floor;
import com.stepanenko.heating.repository.FloorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
public class FloorService {

    final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public void save(Floor floor) {
        log.info("IN FloorService save {}", floor);
        floorRepository.save(floor);
    }

    public Floor getById(Long id) {
        log.info("IN FloorService getById {}", id);
        return floorRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(format("Floor with id = %s is not founded", id)));
    }

    public List<Floor> getAll() {
        log.info("IN FloorService getAll");
        return floorRepository.findAll();
    }

    public void delete(Long id) {
        log.info("IN FloorService delete {}", id);
        floorRepository.deleteById(id);
    }

}
