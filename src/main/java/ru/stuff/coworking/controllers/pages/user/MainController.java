package ru.stuff.coworking.controllers.pages.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stuff.coworking.configuration.CustomUserDetails;
import ru.stuff.coworking.model.UserModel;
import ru.stuff.coworking.repositories.UserRepositories;
import ru.stuff.coworking.services.PointsServices;
import ru.stuff.coworking.services.RoomsServices;
import ru.stuff.coworking.services.UserServices;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController{

    private final PointsServices pointsServices;
    private final RoomsServices roomsServices;
    private final UserServices userServices;

    @GetMapping("/")
    public String index(){
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
    public String support(){
        return "user/support";
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
}
