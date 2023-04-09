package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.PointModel;

@Repository
public interface PointsRepositories extends JpaRepository<PointModel, Integer> {
}
