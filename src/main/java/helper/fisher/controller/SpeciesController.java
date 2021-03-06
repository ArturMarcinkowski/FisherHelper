package helper.fisher.controller;

import helper.fisher.entity.Species;
import helper.fisher.service.SpeciesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/species")
public class SpeciesController {

    private SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping("/add")
    public String add() {
        return "species/form";
    }

    @PostMapping("/add")
    public RedirectView save(@RequestParam("image") MultipartFile multipartFile, Species species) throws IOException {
        speciesService.savePicture(multipartFile, species);
        return new RedirectView("/home", true);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("species", speciesService.findById(id));
        return "species/form";
    }

    @PostMapping("/edit/{id}")
    public String saveEdit(@RequestParam("image") MultipartFile multipartFile, Species species) throws IOException {
        speciesService.savePicture(multipartFile, species);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String institutionDelete(@PathVariable int id) {
        speciesService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable int id, Model model){
        Species species = speciesService.findById(id);
        model.addAttribute("species", species);
        return "species/show";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Species> speciesList = speciesService.findAll();
        model.addAttribute("speciesList", speciesList);
        return "species/list";
    }


}

