package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Section;
import com.stepanenko.heating.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public void save(Section section) {
        log.info("IN SectionService save {}", section);
        sectionRepository.save(section);
    }

    public Section getById(Long id) {
        log.info("IN SectionService getById {}", id);
        return sectionRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(format("Section with id %s is not founded", id)));
    }

    public List<Section> getAll() {
        log.info("IN SectionService getAll");
        return sectionRepository.findAll();
    }

    public void delete(Long id) {
        log.info("IN SectionService delete {}", id);
        sectionRepository.deleteById(id);
    }
}
