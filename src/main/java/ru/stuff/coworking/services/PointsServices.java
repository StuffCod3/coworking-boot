package ru.stuff.coworking.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stuff.coworking.model.PointModel;
import ru.stuff.coworking.repositories.PointsRepositories;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointsServices {
    private final PointsRepositories pointsRepositories;

    public List<PointModel> showPoints(){
        return pointsRepositories.findAll();
    }

    public PointModel showPointById(int id){
        Optional<PointModel> findSocial = pointsRepositories.findById(id);
        return findSocial.orElse(null);
    }

    public void savePoint(PointModel pointModel){
        pointsRepositories.save(pointModel);
    }
}
