package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Section;
import com.stepanenko.heating.repository.SectionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SectionServiceTest {

    @Mock
    private SectionRepository sectionRepository;
    @InjectMocks
    private SectionService sectionService;

    @Test
    public void givenNewSection_whenSave_thenSaved() {
        sectionService.save(TestData.section1);

        verify(sectionRepository).save(TestData.section1);
    }

    @Test
    public void givenExistentSectionNumber_thenNotUniqueNumberExceptionThrow() {

    }

    @Test
    public void givenExistentSectionId_whenGetById_thenReturnSection() {
        when(sectionRepository.findById(1L)).thenReturn(Optional.of(TestData.section1));

        assertEquals(TestData.section1, sectionService.getById(1L));
    }

    @Test
    public void givenNotExistentSectionId_whenGetById_thenEntityNotFoundExceptionThrow() {
        when(sectionRepository.findById(10L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> sectionService.getById(10L));

        String expectedMessage = "Section with id = 10 is not founded";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenGetAll_thenReturnAllSections() {
        List<Section> sections = Arrays.asList(TestData.section1, TestData.section2);
        when(sectionRepository.findAll()).thenReturn(sections);

        assertEquals(sections, sectionService.getAll());
    }

    @Test
    public void givenExistentSectionId_whenDelete_thenDeleted() {
        sectionService.delete(1L);

        verify(sectionRepository).deleteById(1L);
    }


    interface TestData {

        Section section1 = new Section.Builder()
                .setId(1L)
                .setNumber("C1.1")
                .setHeight(35)
                .build();

        Section section2 = new Section.Builder()
                .setId(2L)
                .setNumber("C2.1")
                .setHeight(40)
                .build();
    }
}
