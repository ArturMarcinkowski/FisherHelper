package helper.fisher.controller;

import helper.fisher.entity.User;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class HomeController {


    private final FishSpeciesService fishSpeciesService;
    private final UserService userService;

    public HomeController(FishSpeciesService fishSpeciesService, UserService userService) {
        this.fishSpeciesService = fishSpeciesService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homeAction() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.registerUser(user);
        return "redirect:home";
    }

//    @GetMapping("/du")
//    public String du() throws IOException {
//        ResizeImage.resize("src/main/resources/static/photos/species/18");
//        String[] args = {};
//        ResizeImage1.main(args);
//        return "fds";
//    }

}
