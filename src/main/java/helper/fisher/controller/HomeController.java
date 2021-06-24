package helper.fisher.controller;

import helper.fisher.entity.User;
import helper.fisher.service.FishService;
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


    private final FishService fishService;
    private final UserService userService;

    public HomeController(FishService fishService, UserService userService) {
        this.fishService = fishService;
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

    @GetMapping("/add")
    public String addFish() {
        fishService.addFish();
        return "tu monke";
    }
}
