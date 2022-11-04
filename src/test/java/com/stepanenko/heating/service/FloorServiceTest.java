package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Floor;
import com.stepanenko.heating.repository.FloorRepository;
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
public class FloorServiceTest {

    @Mock
    private FloorRepository floorRepository;
    @InjectMocks
    private FloorService floorService;

    @Test
    public void givenNewFloor_whenSave_thenSaved() {
        floorService.save(TestData.floor1);

        verify(floorRepository).save(TestData.floor1);
    }

    @Test
    public void givenExistentFloorId_whenGetById_thenReturnFloor() {
        when(floorRepository.findById(1L)).thenReturn(Optional.of(TestData.floor1));

        assertEquals(TestData.floor1, floorService.getById(1L));
    }

    @Test
    public void givenNotExistentFloorId_WhenGetById_thenEntityNotFoundExceptionThrow() {
        when(floorRepository.findById(10L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> floorService.getById(10L));

        String expectedMessage = "Floor with id = 10 is not founded";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenGetAll_thenReturnAllFloors(){
        List<Floor> floors = Arrays.asList(TestData.floor1, TestData.floor2);

        when(floorRepository.findAll()).thenReturn(floors);

        assertEquals(floors, floorService.getAll());
    }

    @Test
    public void givenExistentFloorId_whenDelete_thenDeleted(){
        floorService.delete(1L);

        verify(floorRepository).deleteById(1L);
    }

    interface TestData {

        Floor floor1 = new Floor.Builder()
                .setId(1L)
                .setName(2)
                .setHeight(3)
                .setHighMark(3.5)
                .build();

        Floor floor2 = new Floor.Builder()
                .setId(2L)
                .setName(3)
                .setHeight(4)
                .setHighMark(7)
                .build();
    }
}
