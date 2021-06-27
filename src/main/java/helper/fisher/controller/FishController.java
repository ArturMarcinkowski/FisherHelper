package helper.fisher.controller;

import helper.fisher.entity.Fish;
import helper.fisher.service.FishService;
import helper.fisher.service.SpeciesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/fish")
public class FishController {

    private SpeciesService speciesService;
    private FishService fishService;

    public FishController(SpeciesService speciesService, FishService fishService) {
        this.speciesService = speciesService;
        this.fishService = fishService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("species", speciesService.findAll());
        return "fish/form";
    }

    @PostMapping("/add")
    public String save(@Valid Fish fish, BindingResult result) {
        if (result.hasErrors()) {
            return "fish/add";
        }
        fishService.save(fish);
        return "redirect:home";
    }

}
