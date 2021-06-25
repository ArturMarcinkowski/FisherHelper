package helper.fisher.controller;

import helper.fisher.entity.FishSpecies;
import helper.fisher.entity.User;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;




@Controller
@RequestMapping("/species")
public class FishSpeciesController {

    @Autowired
    private FishSpeciesService speciesService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("species", new FishSpecies());
        return "form";
    }


    @PostMapping("/add")
    public String save(@Valid FishSpecies species, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/home";
        }
        speciesService.save(species);
        return "redirect:/home";
    }

    @GetMapping("/add-photo")
    public String addPhoto(Model model) {
        model.addAttribute("species", new FishSpecies());
        return "form-photo";
    }

    @PostMapping("/add-photo")
    public RedirectView savePhoto(@RequestParam("image") MultipartFile multipartFile, FishSpecies species) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        species.setPhotos(fileName);
        FishSpecies savedSpecies = speciesService.save(species);
        String uploadDir = "user-photos/" + savedSpecies.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/home", true);
    }



}


//@Controller
//public class FishSpeciesController {
//
//
//    public FishSpeciesController(FishSpeciesService fishSpeciesService) {
//        this.fishSpeciesService = fishSpeciesService;
//    }
//
//    @GetMapping("/")
//    public String addFish() {
//        fishSpeciesService.addFish();
//        return "tu monke";
//    }
//
//
//}
//
