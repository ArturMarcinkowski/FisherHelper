package helper.fisher.controller;

import helper.fisher.entity.FishSpecies;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;



@Controller
@RequestMapping("/species")
public class FishSpeciesController {

    @Autowired
    private FishSpeciesService speciesService;

    @GetMapping("/add")
    public String addPhoto() {
        return "species/form";
    }

    @PostMapping("/add")
    public RedirectView savePhoto(@RequestParam("image") MultipartFile multipartFile, FishSpecies species) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        species.setPhotos(fileName);
        FishSpecies savedSpecies = speciesService.save(species);
        String uploadDir = "src/main/webapp/resources/photos/" + savedSpecies.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/home", true);
    }

    @GetMapping("/show")
    public String show(@RequestParam int id, Model model){
        FishSpecies species = speciesService.findById(id);
        model.addAttribute("species", species);
        return "species/show";
    }
}

