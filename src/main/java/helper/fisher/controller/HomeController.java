package helper.fisher.controller;

import helper.fisher.service.FishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    private final FishService fishService;

    public HomeController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/home")
    public String homeAction() {
        return "index";
    }

    @GetMapping("/add")
    public String addFish() {
        fishService.addFish();
        return "tu monke";
    }
}
