package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.PointModel;
import ru.stuff.coworking.model.RoomModel;
import ru.stuff.coworking.repositories.RoomsRepositories;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomsServices {

    private final RoomsRepositories roomsRepositories;

    public List<RoomModel> showRooms(){
        return roomsRepositories.findAll();
    }

    public RoomModel showRoomById(int id){
        Optional<RoomModel> findRoom = roomsRepositories.findById(id);
        return findRoom.orElse(null);
    }

    public void saveRoom(RoomModel roomModel){
        roomsRepositories.save(roomModel);
    }
}
