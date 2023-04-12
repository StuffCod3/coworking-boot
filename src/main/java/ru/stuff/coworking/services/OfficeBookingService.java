package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.OfficeBookingModel;
import ru.stuff.coworking.model.PointModel;
import ru.stuff.coworking.model.UserModel;
import ru.stuff.coworking.repositories.OfficeBookingRepositories;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeBookingService {

    private final OfficeBookingRepositories officeBookingRepositories;

    public List<OfficeBookingModel> showAllOfficeBooking(){
        return officeBookingRepositories.findAll();
    }

    public OfficeBookingModel findOfficeById(int id){
        return officeBookingRepositories.findById(id).orElse(null);
    }

    public void createOfficeBooking(OfficeBookingModel officeBookingModel){
        officeBookingRepositories.save(officeBookingModel);
    }
}
