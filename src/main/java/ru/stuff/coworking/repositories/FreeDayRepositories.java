package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.FreeDayModel;
import ru.stuff.coworking.model.PointModel;

@Repository
public interface FreeDayRepositories extends JpaRepository<FreeDayModel, Integer> {
}
