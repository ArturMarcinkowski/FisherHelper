package helper.fisher.controller;

import helper.fisher.entity.Capture;
import helper.fisher.entity.Fish;
import helper.fisher.service.CaptureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/capture")
public class CaptureController {

    private final CaptureService captureService;

    public CaptureController(CaptureService captureService) {
        this.captureService = captureService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("capture", new Capture());
        return "capture/form";
    }

    @PostMapping("/add")
    public String save(@Valid Capture capture, BindingResult result) {
        if (result.hasErrors()) {
            return "capture/form";
        }
        capture = captureService.save(capture);
        return "redirect:add-fishes/" + capture.getId();
    }

    @GetMapping("/add-fishes/{id}")
    public String addFishes(@PathVariable int id, Model model) {
        List<Fish> fishes = captureService.getAllFishes(id);
        model.addAttribute("fishes", fishes);

        int numberOfMissingFishes = captureService.getById(id).getFishAmount() - fishes.size();
        model.addAttribute("missingFishesAmount", numberOfMissingFishes);
        return "capture/form-fishes";
    }


    @GetMapping("/list")
    public String list() {
        return "capture/list";
    }


}
