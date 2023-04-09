package ru.stuff.coworking.controllers.pages.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stuff.coworking.model.PointModel;
import ru.stuff.coworking.model.RoomModel;
import ru.stuff.coworking.services.PointsServices;
import ru.stuff.coworking.services.RoomsServices;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final PointsServices pointsServices;
    private final RoomsServices roomsServices;

    @GetMapping("/admin/addPoint")
    public String pageAddPoint(Model model){
        model.addAttribute("points", new PointModel());
        return "admin/add_point";
    }

    @PostMapping("/admin/addPoint")
    public String createPoint(@ModelAttribute PointModel pointModel){
        pointsServices.savePoint(pointModel);
        return "user/index";
    }

    @GetMapping("/admin/addRoom")
    public String pageAddRoom(Model model){
        model.addAttribute("rooms", new RoomModel());
        return "admin/add_room";
    }

    @PostMapping("/admin/addRoom")
    public String createRoom(@ModelAttribute RoomModel roomModel){
        roomsServices.saveRoom(roomModel);
        return "user/index";
    }

}
