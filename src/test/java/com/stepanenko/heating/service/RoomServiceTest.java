package com.stepanenko.heating.service;

import com.stepanenko.heating.model.Room;
import com.stepanenko.heating.repository.RoomRepository;
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
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private RoomService roomService;

    @Test
    public void givenNewRoom_whenSave_thenSaved(){
        roomService.save(TestData.room1);

        verify(roomRepository).save(TestData.room1);
    }

    @Test
    public void givenRoomWithExistentNumber_whenSave_thenNotUniqueNumberExceptionThrow(){

    }

    @Test
    public void givenExistentRoomId_whenGetById_thenReturnRoom() throws EntityNotFoundException {
        when(roomRepository.findById(1L)).thenReturn(Optional.of(TestData.room1));

        assertEquals(TestData.room1, roomService.getById(1L));
    }

    @Test
    public void givenNotExistentRoomId_whenGetById_thenEntityNotFoundExceptionThrow(){
        when(roomRepository.findById(10L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> roomService.getById(10L));

        String expectedMessage = "Room with id = 10 is not found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenGetAll_thenReturn(){
        List<Room> rooms = Arrays.asList(TestData.room1, TestData.room2);

        when(roomRepository.findAll()).thenReturn(rooms);

        assertEquals(rooms, roomService.getAll());
    }

    @Test
    public void givenExistentRoomId_whenDelete_thenDeleted(){
        roomService.delete(1L);

        verify(roomRepository).deleteById(1L);
    }

    interface TestData {
        Room room1 = new Room.Builder()
                .setId(1L)
                .setName("Living room")
                .setNumber("101")
                .setTemperature(22)
                .build();

        Room room2 = new Room.Builder()
                .setId(2L)
                .setName("Kitchen")
                .setNumber("202")
                .setTemperature(20)
                .build();
    }
}
