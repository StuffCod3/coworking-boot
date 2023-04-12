package ru.stuff.coworking.controllers.pages.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stuff.coworking.configuration.CustomUserDetails;
import ru.stuff.coworking.model.*;
import ru.stuff.coworking.repositories.UserRepositories;
import ru.stuff.coworking.services.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController{

    private final PointsServices pointsServices;
    private final RoomsServices roomsServices;
    private final UserServices userServices;
    private final FreeDayServices freeDayServices;
    private final TicketServices ticketServices;
    private final OfficeBookingService officeBookingService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("free", new FreeDayModel());
        return "user/index";
    }

    @GetMapping("/meeting_room")
    public String meeting(Model model){
        model.addAttribute("rooms", roomsServices.showRooms());
        return "user/meeting_rooms";
    }

    @GetMapping("/offices")
    public String offices(Model model){
        model.addAttribute("points", pointsServices.showPoints());
        return "user/offices";
    }

    @GetMapping("/offices/{id}")
    public String officeById(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("point", pointsServices.showPointById(id));
        model.addAttribute("booking", new OfficeBookingModel());
        return "user/office";
    }

    @PostMapping("/offices/{id}")
    public String bookingOffice(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                OfficeBookingModel officeBookingModel, @PathVariable("id") int id){
        String email = customUserDetails.getUsername();

        PointModel pointModel = pointsServices.showPointById(id);

        officeBookingModel.setEmail(email);
        officeBookingModel.setPoint(pointModel.getTitle());
        officeBookingService.createOfficeBooking(officeBookingModel);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        return "user/profile";
    }

    @GetMapping("/profile/guest")
    public String guest(){
        return "user/guest";
    }

    @GetMapping("/profile/settings")
    public String settings(){
        return "user/settings";
    }

    @GetMapping("/profile/settings/editPass")
    public String editPass(Model model){
        model.addAttribute("user", new UserModel());
        return "user/edit_pass";
    }

    @PostMapping("/profile/settings/editPass")
    public String editPassPost(@AuthenticationPrincipal CustomUserDetails customUserDetails, @ModelAttribute("user") UserModel model){
        String email = customUserDetails.getUsername();
        Optional<UserModel> userModel = userServices.searchByEmail(email);

        UserModel user = userModel.get();
        String newPass = model.getPassword();
        user.setPassword(newPass);
        userServices.updatePassUser(user);
        return "user/edit_pass";
    }

    @GetMapping("/profile/tarifs")
    public String tarifs(){
        return "user/tarifs";
    }

    @GetMapping("/support")
    public String support(Model model){
        model.addAttribute("ticket", new TicketsModel());
        return "user/support";
    }

    @PostMapping("/support")
    public String supportTicket(@AuthenticationPrincipal CustomUserDetails customUserDetails, @ModelAttribute("ticket") TicketsModel ticketsModel){
        String email = customUserDetails.getUsername();
        Optional<UserModel> userModel = userServices.searchByEmail(email);
        ticketsModel.setEmail(userModel.get().getEmail());
        ticketServices.createTicket(ticketsModel);
        return "user/profile";
    }

    @GetMapping("/sign_in")
    public String sign_in(){
        return "user/sign_in";
    }

    @GetMapping("/sign_up")
    public String signUpOpenPage(Model model){
        model.addAttribute("usr", new UserModel());
        return "user/sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute("usr") UserModel userModel){
        userServices.createUser(userModel);
        return "user/sign_in";
    }

    @PostMapping("/takeFree")
    public String freeDayTake(@ModelAttribute("free") FreeDayModel freeDayModel){
        freeDayServices.createDay(freeDayModel);
        return "user/index";
    }
}
