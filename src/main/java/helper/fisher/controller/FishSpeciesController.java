package helper.fisher.controller;

import helper.fisher.entity.FishSpecies;
import helper.fisher.entity.User;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;




@Controller
public class FishSpeciesController {

    @Autowired
    private FishSpeciesService speciesService;

    @GetMapping("/add-species")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }


    @PostMapping("/users/save")
    public RedirectView saveUser(FishSpecies species,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        species.setPhotos(fileName);

        FishSpecies savedSpecies = speciesService.save(species);

        String uploadDir = "user-photos/" + savedSpecies.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/users", true);
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
