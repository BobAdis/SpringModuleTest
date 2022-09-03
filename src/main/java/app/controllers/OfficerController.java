package app.controllers;

import app.models.Officer;
import app.services.OfficerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfficerController {
    private final OfficerService officerService;

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @GetMapping(value = {"/newofficer"})
    public String saveNewOfficer(Model model) {
        model.addAttribute("officer", new Officer());
        return "newofficer";
    }

    @PostMapping(value = {"/newofficer"})
    public String saveUser(Officer officer) {
        officerService.saveUser(officer);
        return "redirect:/login";
    }
    @GetMapping(value = {"/error"})
    public String registerErrorPage(Model model) {
        model.addAttribute("registerError", true);
        return "newofficer";
    }
}
