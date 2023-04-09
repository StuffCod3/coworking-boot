package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.RoomModel;

@Repository
public interface RoomsRepositories extends JpaRepository<RoomModel, Integer> {
}
