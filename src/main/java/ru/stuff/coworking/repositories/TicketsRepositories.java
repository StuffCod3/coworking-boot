package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.TicketsModel;

@Repository
public interface TicketsRepositories extends JpaRepository<TicketsModel, Integer> {
}
