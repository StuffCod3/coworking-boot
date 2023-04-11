package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.UserModel;
import ru.stuff.coworking.repositories.UserRepositories;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepositories userRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserModel userModel){
        Double d = Math.random() * (9999 - 1001) + 1001;
        int code = d.intValue();
        userModel.setCode(code);
        userModel.setDiscount(false);
        userModel.setCoffee(false);
        userModel.setCloset(false);
        userModel.setRole("ROLE_USER");
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepositories.save(userModel);
    }

    public void updatePassUser(UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepositories.save(userModel);
    }

    public Optional<UserModel> searchByEmail(String email){
        return userRepositories.findByEmail(email);
    }
}
