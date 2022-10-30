package com.stepanenko.heating.rest;

import com.stepanenko.heating.model.Section;
import com.stepanenko.heating.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sections/")
public class SectionRestControllerV1 {

    private final SectionService sectionService;

    public SectionRestControllerV1(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    public ResponseEntity<Section> saveSection(@RequestBody Section section) {
        sectionService.save(section);
        return new ResponseEntity<>(section, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Section> getSection(@PathVariable Long id) {
        Section section = sectionService.getById(id);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Section>> getSections() {
        List<Section> sections = sectionService.getAll();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Section> updateSection(@RequestBody Section section) {
        sectionService.save(section);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Section> deleteSection(@PathVariable Long id) {
        sectionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
