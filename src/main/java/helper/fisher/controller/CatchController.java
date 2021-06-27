package helper.fisher.controller;

import helper.fisher.entity.Capture;
import helper.fisher.service.CaptureService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CatchController {

    private final CaptureService captureService;

    public CatchController(CaptureService captureService) {
        this.captureService = captureService;
    }

    @GetMapping("/add")
    public String add() {
        return "capture/form";
    }

    @PostMapping("/add")
    public String save(@Valid Capture capture, BindingResult result) {
        if (result.hasErrors()) {
            return "capture/add";
        }
        captureService.save(capture);
        return "redirect:home";
    }


}
