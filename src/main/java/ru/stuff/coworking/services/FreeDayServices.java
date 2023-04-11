package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.FreeDayModel;
import ru.stuff.coworking.repositories.FreeDayRepositories;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreeDayServices {

    private final FreeDayRepositories freeDayRepositories;

    public List<FreeDayModel> showDays(){
        return freeDayRepositories.findAll();
    }

    public FreeDayModel searchDayById(int id){
        Optional<FreeDayModel> freeDayModel = freeDayRepositories.findById(id);
        return freeDayModel.orElse(null);
    }

    public void createDay(FreeDayModel freeDayModel){
        freeDayRepositories.save(freeDayModel);
    }
}
