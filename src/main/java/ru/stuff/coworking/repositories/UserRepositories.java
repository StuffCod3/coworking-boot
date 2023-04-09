package ru.stuff.coworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stuff.coworking.model.UserModel;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface UserRepositories extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmail(String email);
}
