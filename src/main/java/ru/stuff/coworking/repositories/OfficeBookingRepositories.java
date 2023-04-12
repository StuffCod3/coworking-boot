package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.OfficeBookingModel;

@Repository
public interface OfficeBookingRepositories extends JpaRepository<OfficeBookingModel, Integer> {
}
